package com.andyadc.starter.whitelist.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(WhitelistProperties.class)
@EnableConfigurationProperties(WhitelistProperties.class)
public class WhitelistAutoConfigure {

    @Bean("whitelistConfig")
    @ConditionalOnMissingBean
    public String whitelistConfig(WhitelistProperties properties) {
        return properties.getUsers();
    }
}
