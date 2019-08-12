package org.ougen.springbootdemo.components;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: OuGen
 * Discription:
 * Date: 23:31 2019/7/17
 */
@ConfigurationProperties("spring.redis.jedis.pool")
@Component
@Data
public class JedisPoolProperties {
    private String minIdle;
    private String maxActive;
}
