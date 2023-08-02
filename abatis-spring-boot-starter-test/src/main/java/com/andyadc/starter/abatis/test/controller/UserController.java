package com.andyadc.starter.abatis.test.controller;

import com.andyadc.starter.abatis.test.entity.User;
import com.andyadc.starter.abatis.test.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/api/user/query")
    public User query(@RequestParam Long userId) {
        logger.info("Query: {}", userId);
        return userMapper.selectByUserId(userId);
    }
}
