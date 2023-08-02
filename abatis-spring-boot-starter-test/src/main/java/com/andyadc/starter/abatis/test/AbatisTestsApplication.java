package com.andyadc.starter.abatis.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.andyadc.starter"})
@SpringBootApplication
public class AbatisTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbatisTestsApplication.class, args);
    }
}
