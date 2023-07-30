package com.andyadc.starter.whitelist.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.andyadc.starter"})
@SpringBootApplication
public class WhitelistTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhitelistTestApplication.class, args);
    }
}
