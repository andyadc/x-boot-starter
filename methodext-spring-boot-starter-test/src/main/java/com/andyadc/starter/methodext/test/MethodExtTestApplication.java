package com.andyadc.starter.methodext.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.andyadc.starter"})
@SpringBootApplication
public class MethodExtTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MethodExtTestApplication.class, args);
    }
}
