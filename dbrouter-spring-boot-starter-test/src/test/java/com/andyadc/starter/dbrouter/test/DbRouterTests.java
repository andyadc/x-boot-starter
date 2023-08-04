package com.andyadc.starter.dbrouter.test;

import com.alibaba.fastjson2.JSON;
import com.andyadc.starter.dbrouter.test.entity.User;
import com.andyadc.starter.dbrouter.test.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class DbRouterTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_selectByUserId() {
        User query = new User();
        query.setUserId(11111222L);
        User user = userMapper.selectByUserId(query);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void test_insert() {
        User user = new User();
        user.setUserId(11111222L);
        user.setAge(12);
        user.setName("666");
        user.setNickname("777");
        user.setPassword(UUID.randomUUID().toString());
        userMapper.insert(user);
    }
}
