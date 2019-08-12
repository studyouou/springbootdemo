package org.ougen.springbootdemo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Author: OuGen
 * Discription:
 * Date: 10:46 2019/7/18
 */
@Component
public class MyRedisTemplet {
    private StringRedisTemplate stringRedisTemplate;

    public MyRedisTemplet(StringRedisTemplate stringRedisTemplate){
        this.stringRedisTemplate=stringRedisTemplate;
        stringRedisTemplate.setHashValueSerializer(new RedisObjectSerialier());
    }
    public void putHash(String name,String key,Object value){
        stringRedisTemplate.opsForHash().put(name,key,value);
    }
    public Object getHash(String name,String key){
        return stringRedisTemplate.opsForHash().get(name,key);
    }
    public void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}
