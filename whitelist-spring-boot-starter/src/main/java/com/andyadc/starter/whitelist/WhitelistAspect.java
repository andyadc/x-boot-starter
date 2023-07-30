package com.andyadc.starter.whitelist;

import com.alibaba.fastjson2.JSON;
import com.andyadc.starter.whitelist.annotation.Whitelist;
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
public class WhitelistAspect {

    private static final Logger logger = LoggerFactory.getLogger(WhitelistAspect.class);

    @Resource
    private String whitelistConfig;

    @Pointcut("@annotation(com.andyadc.starter.whitelist.annotation.Whitelist)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Method method = getMethod(point);
        Whitelist whitelist = method.getAnnotation(Whitelist.class);

        String value = getFieldValue(whitelist.key(), point.getArgs());
        if (!StringUtils.hasText(value)) {
            return point.proceed();
        }

        String[] us = whitelistConfig.split(",");
        for (String u : us) {
            if (value.equals(u)) {
                return point.proceed();
            }
        }

        return returnObj(whitelist, method);
    }

    private Method getMethod(JoinPoint joinPoint) throws NoSuchMethodException {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        return joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    private Object returnObj(Whitelist whitelist, Method method) throws IllegalAccessException, InstantiationException {
        Class<?> returnType = method.getReturnType();
        String returnJson = whitelist.returnJson();
        if (!StringUtils.hasText(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    private String getFieldValue(String field, Object[] args) {
        String fieldValue = null;
        for (Object arg : args) {
            try {
                if (StringUtils.hasText(fieldValue)) {
                    break;
                } else {
                    fieldValue = BeanUtils.getProperty(arg, field);
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return fieldValue;
    }
}
