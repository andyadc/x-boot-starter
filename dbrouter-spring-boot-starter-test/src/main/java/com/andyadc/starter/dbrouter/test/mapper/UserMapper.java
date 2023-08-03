package com.andyadc.starter.dbrouter.test.mapper;

import com.andyadc.starter.dbrouter.annotation.DBRouter;
import com.andyadc.starter.dbrouter.test.entity.User;

import java.util.List;

public interface UserMapper {

    @DBRouter(key = "userId")
    User selectByUserId(Long userId);

    @DBRouter(key = "userId")
    List<User> selectUserList(User user);
}
