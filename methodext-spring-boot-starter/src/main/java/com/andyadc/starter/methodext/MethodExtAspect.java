package com.andyadc.starter.methodext;

import com.alibaba.fastjson2.JSON;
import com.andyadc.starter.methodext.annotation.DoMethodExt;
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

import java.lang.reflect.Method;

@Component
@Aspect
public class MethodExtAspect {

    private static final Logger logger = LoggerFactory.getLogger(MethodExtAspect.class);

    @Pointcut("@annotation(com.andyadc.starter.methodext.annotation.DoMethodExt)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Method method = getMethod(point);
        DoMethodExt doMethodExt = method.getAnnotation(DoMethodExt.class);

        // 获取拦截方法
        String methodName = doMethodExt.method();
        // 功能处理
        Method methodExt = getClass(point).getMethod(methodName, method.getParameterTypes());
        Class<?> returnType = methodExt.getReturnType();

        // 判断方法返回类型
        if (!"boolean".equals(returnType.getName())) {
            throw new RuntimeException("annotation @DoMethodExt set method：" + methodName + " returnType is not boolean");
        }
        // 拦截判断正常，继续
        boolean invoke = (boolean) methodExt.invoke(point.getThis(), point.getArgs());
        return invoke ? point.proceed() : JSON.parseObject(doMethodExt.returnJson(), method.getReturnType());
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    private Class<? extends Object> getClass(JoinPoint jp) {
        return jp.getTarget().getClass();
    }
}
