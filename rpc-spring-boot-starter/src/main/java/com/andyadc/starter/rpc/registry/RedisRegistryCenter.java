package com.andyadc.starter.rpc.registry;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis 模拟RPC注册中心
 */
public class RedisRegistryCenter {

    private static Jedis jedis; // 非切片的客户端连接

    //初始化redis
    public static void init(String host, int port) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(5);
        config.setTestOnBorrow(false);
        JedisPool jedisPool = new JedisPool(config, host, port);
        jedis = jedisPool.getResource();
    }

    /**
     * 注册生产者
     */
    public static Long registryProvider(String clazz, String alias, String info) {
        return jedis.sadd(clazz + "_" + alias, info);
    }

    /**
     * 获取生产者
     */
    public static String obtainProvider(String clazz, String alias) {
        return jedis.srandmember(clazz + "_" + alias);
    }

    public static Jedis jedis() {
        return jedis;
    }
}
