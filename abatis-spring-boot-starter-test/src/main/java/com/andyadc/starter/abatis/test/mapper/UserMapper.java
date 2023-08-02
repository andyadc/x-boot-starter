package com.andyadc.starter.abatis.test.mapper;

import com.andyadc.starter.abatis.test.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByUserId(Long userId);

    List<User> selectUserList(User user);
}
