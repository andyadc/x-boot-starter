package com.andyadc.abatis.spring.test;

import com.alibaba.fastjson2.JSON;
import com.andyadc.abatis.spring.test.entity.User;
import com.andyadc.abatis.spring.test.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {

    @Test
    public void test_ClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        UserMapper userMapper = applicationContext.getBean("userMapper", UserMapper.class);
        User user = userMapper.selectByUserId(1L);
        System.out.println(JSON.toJSON(user));
    }
}
