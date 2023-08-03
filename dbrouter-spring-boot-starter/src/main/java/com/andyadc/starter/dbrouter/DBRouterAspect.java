package com.andyadc.starter.dbrouter;

import com.andyadc.starter.dbrouter.annotation.DBRouter;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@Component
@Aspect
public class DBRouterAspect {

    private static final Logger logger = LoggerFactory.getLogger(DBRouterAspect.class);

    @Resource
    private DBRouterConfig dbRouterConfig;

    @Pointcut("@annotation(com.andyadc.starter.dbrouter.annotation.DBRouter)")
    public void pointcut() {
    }

    @Around("pointcut() && @annotation(dbRouter)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, DBRouter dbRouter) throws Throwable {
        String dbKey = dbRouter.key();
        if (!StringUtils.hasLength(dbKey)) {
            throw new RuntimeException("annotation DBRouter key is null！");
        }

        // 计算路由
        String dbKeyAttr = getAttrValue(dbKey, proceedingJoinPoint.getArgs());
        int size = dbRouterConfig.getDbCount() * dbRouterConfig.getTbCount();
        // 扰动函数
        int idx = (size - 1) & (dbKeyAttr.hashCode() ^ (dbKeyAttr.hashCode() >>> 16));
        // 库表索引
        int dbIdx = idx / dbRouterConfig.getTbCount() + 1;
        int tbIdx = idx - dbRouterConfig.getTbCount() * (dbIdx - 1);
        // 设置到 ThreadLocal
        DBContextHolder.setDBKey(String.format("%02d", dbIdx));
        DBContextHolder.setTBKey(String.format("%02d", tbIdx));
        logger.info("数据库路由 method：{} dbIdx：{} tbIdx：{}", getMethod(proceedingJoinPoint).getName(), dbIdx, tbIdx);

        // 返回结果
        try {
            return proceedingJoinPoint.proceed();
        } finally {
            DBContextHolder.clearDBKey();
            DBContextHolder.clearTBKey();
        }
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    public String getAttrValue(String attr, Object[] args) {
        String filedValue = null;
        for (Object arg : args) {
            try {
                if (StringUtils.hasLength(filedValue)) {
                    break;
                }
                filedValue = BeanUtils.getProperty(arg, attr);
            } catch (Exception e) {
                logger.error("获取路由属性值失败 attr：{}", attr, e);
            }
        }
        return filedValue;
    }
}
