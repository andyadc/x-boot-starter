package com.andyadc.starter.ratelimiter.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.andyadc.starter"})
@SpringBootApplication
public class RateLimiterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimiterTestApplication.class, args);
    }
}
