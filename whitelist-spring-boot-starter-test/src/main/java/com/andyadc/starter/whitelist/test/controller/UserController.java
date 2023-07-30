package com.andyadc.starter.whitelist.test.controller;

import com.andyadc.starter.whitelist.annotation.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Whitelist(key = "username", returnJson = "{\"code\":\"9999\", \"message\":\"Not Whitelist user\"}")
    @RequestMapping("/api/user/query")
    public User query(@RequestParam String username) {
        logger.info("Query: {}", username);
        return new User(username);
    }

}
