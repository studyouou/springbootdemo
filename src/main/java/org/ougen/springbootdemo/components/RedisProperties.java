package org.ougen.springbootdemo.components;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: OuGen
 * Discription:
 * Date: 23:24 2019/7/17
 */
@ConfigurationProperties(prefix = "spring.redis")
@Component
@Data
public class RedisProperties {
    private String host;
    private int port;
    private String password;
    @Autowired
    private JedisPoolProperties jedisPoolProperties;
}
