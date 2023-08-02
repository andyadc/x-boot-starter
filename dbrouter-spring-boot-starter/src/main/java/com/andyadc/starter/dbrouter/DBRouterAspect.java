package com.andyadc.starter.dbrouter;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DBRouterAspect {

    private static final Logger logger = LoggerFactory.getLogger(DBRouterAspect.class);

}
