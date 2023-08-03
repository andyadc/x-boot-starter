package com.andyadc.starter.redis.test.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisStarterTests {

    @Autowired
    private RedisService redisService;

    @Test
    public void testGet() {
        String result = redisService.get("a");
        System.out.println(result);
    }

    @Test
    public void testSet() {
        redisService.set("a", "xxxxxxxxxxx");
    }
}
