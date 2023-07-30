package com.andyadc.starter.ratelimiter.test.controller;

import com.andyadc.starter.ratelimiter.annotation.DoRateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @DoRateLimiter(permitsPerSecond = 1D, returnJson = "{\"code\":\"9998\", \"message\":\"Request exceed\"}")
    @RequestMapping("/api/user/query")
    public User query(@RequestParam String username) {
        logger.info("Query: {}", username);
        return new User(username);
    }

}
