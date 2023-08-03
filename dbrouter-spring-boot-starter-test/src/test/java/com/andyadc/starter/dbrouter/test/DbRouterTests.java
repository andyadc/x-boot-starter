package com.andyadc.starter.dbrouter.test;

import com.alibaba.fastjson2.JSON;
import com.andyadc.starter.dbrouter.test.entity.User;
import com.andyadc.starter.dbrouter.test.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DbRouterTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_selectByUserId() {
        User user = userMapper.selectByUserId(1L);
        System.out.println(JSON.toJSONString(user));
    }
}
