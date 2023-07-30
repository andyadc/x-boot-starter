package com.andyadc.starter.ratelimiter;

import com.andyadc.starter.ratelimiter.annotation.DoRateLimiter;
import com.andyadc.starter.ratelimiter.valve.ValveService;
import com.andyadc.starter.ratelimiter.valve.impl.ValveServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class RateLimiterAspect {

    @Pointcut("@annotation(com.andyadc.starter.ratelimiter.annotation.DoRateLimiter)")
    public void pointcut() {
    }

    @Around("pointcut() && @annotation(doRateLimiter)")
    public Object around(ProceedingJoinPoint point, DoRateLimiter doRateLimiter) throws Throwable {
        ValveService valveService = new ValveServiceImpl();
        return valveService.access(point, getMethod(point), doRateLimiter, point.getArgs());
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return jp.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }
}
