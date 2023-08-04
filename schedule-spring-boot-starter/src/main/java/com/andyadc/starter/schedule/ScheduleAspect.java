package com.andyadc.starter.schedule;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ScheduleAspect {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleAspect.class);

    @Pointcut("@annotation(com.andyadc.starter.schedule.annotation.DcsScheduled)")
    public void pointcut() {
    }
}
