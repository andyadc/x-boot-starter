package com.andyadc.starter.rpc.config;

import com.andyadc.starter.rpc.registry.RedisRegistryCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;

public class ServerAutoConfiguration implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ServerAutoConfiguration.class);

    @Resource
    private ServerProperties serverProperties;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        logger.info("启动Redis模拟注册中心开始");
        RedisRegistryCenter.init(serverProperties.getHost(), serverProperties.getPort());
        logger.info("启动Redis模拟注册中心完成，{} {}", serverProperties.getHost(), serverProperties.getPort());

        logger.info("初始化生产端服务开始");

    }
}
