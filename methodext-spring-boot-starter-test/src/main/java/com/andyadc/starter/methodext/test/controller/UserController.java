package com.andyadc.starter.methodext.test.controller;

import com.andyadc.starter.methodext.annotation.DoMethodExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @DoMethodExt(method = "blacklist", returnJson = "{\"code\":\"9997\", \"message\":\"Method forbidden\"}")
    @RequestMapping("/api/user/query")
    public User query(@RequestParam String username) {
        logger.info("Query: {}", username);
        return new User(username);
    }

    public boolean blacklist(@RequestParam String username) {
        if ("a".equals(username) || "c".equals(username)) {
            logger.warn("intercept user: {}", username);
            return false;
        }
        return true;
    }
}
