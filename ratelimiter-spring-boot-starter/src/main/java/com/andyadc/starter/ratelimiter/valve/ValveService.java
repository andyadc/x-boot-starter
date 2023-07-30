package com.andyadc.starter.ratelimiter.valve;

import com.andyadc.starter.ratelimiter.annotation.DoRateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

public interface ValveService {

    Object access(ProceedingJoinPoint point, Method method, DoRateLimiter limiter, Object[] args) throws Throwable;
}
