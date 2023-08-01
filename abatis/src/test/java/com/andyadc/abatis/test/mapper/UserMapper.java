package com.andyadc.abatis.test.mapper;

import com.andyadc.abatis.test.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByUserId(Long userId);

    List<User> selectUserList(User user);
}
