package com.andyadc.abatis.test;

import com.alibaba.fastjson2.JSON;
import com.andyadc.abatis.DefaultSqlSessionFactory;
import com.andyadc.abatis.Resources;
import com.andyadc.abatis.SqlSession;
import com.andyadc.abatis.SqlSessionFactoryBuilder;
import com.andyadc.abatis.test.entity.User;
import org.junit.jupiter.api.Test;

import java.io.Reader;

public class Tests {

    @Test
    public void test_query() throws Exception {
        String resource = "abatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);

        DefaultSqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.open();

        User user = new User();
        user.setUserId(10L);
        Object o = sqlSession.selectOne("com.andyadc.abatis.test.mapper.UserMapper.selectByUserId", user);
        System.out.println(JSON.toJSON(o));

        sqlSession.close();
    }
}
