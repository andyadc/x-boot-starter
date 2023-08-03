package com.andyadc.starter.dbrouter.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.andyadc.starter"})
@SpringBootApplication
public class DbRouterTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbRouterTestApplication.class, args);
    }
}
