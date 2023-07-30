package com.andyadc.starter.ratelimiter.valve.impl;

import com.alibaba.fastjson2.JSON;
import com.andyadc.starter.ratelimiter.Constants;
import com.andyadc.starter.ratelimiter.annotation.DoRateLimiter;
import com.andyadc.starter.ratelimiter.valve.ValveService;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

public class ValveServiceImpl implements ValveService {

    @Override
    public Object access(ProceedingJoinPoint point, Method method, DoRateLimiter limiter, Object[] args) throws Throwable {
        if (limiter.permitsPerSecond() == 0D) {
            return point.proceed();
        }

        String name = point.getTarget().getClass().getName();
        String methodName = method.getName();

        String key = name + "." + methodName;

        if (Constants.rateLimiterMap.get(key) == null) {
            Constants.rateLimiterMap.put(key, RateLimiter.create(limiter.permitsPerSecond()));
        }

        RateLimiter rateLimiter = Constants.rateLimiterMap.get(key);
        if (rateLimiter.tryAcquire()) {
            return point.proceed();
        }

        return JSON.parseObject(limiter.returnJson(), method.getReturnType());
    }
}
