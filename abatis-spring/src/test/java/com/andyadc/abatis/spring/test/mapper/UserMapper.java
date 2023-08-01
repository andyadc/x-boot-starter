package com.andyadc.abatis.spring.test.mapper;

import com.andyadc.abatis.spring.test.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByUserId(Long userId);

    List<User> selectUserList(User user);
}
