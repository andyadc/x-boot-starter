package com.andyadc.starter.dbrouter.test.mapper;

import com.andyadc.starter.dbrouter.annotation.DBRouter;
import com.andyadc.starter.dbrouter.test.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @DBRouter(key = "userId")
    User selectByUserId(User user);

    @DBRouter(key = "userId")
    int insert(User user);
}
