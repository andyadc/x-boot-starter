package com.andyadc.starter.redis.test.service;

import com.andyadc.starter.redis.annotation.XRedis;

@XRedis
public interface RedisService {

    String get(String key);

    void set(String key, String val);
}
