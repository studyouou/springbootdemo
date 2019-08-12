package org.ougen.springbootdemo;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ougen.springbootdemo.components.User;
import org.ougen.springbootdemo.jparesi.StudentResi;
import org.ougen.springbootdemo.jpaservice.Service1;
import org.ougen.springbootdemo.jpaservice.Service2;
import org.ougen.springbootdemo.model.Student;
import org.ougen.springbootdemo.redis.RedisObjectSerialier;
import org.ougen.springbootdemo.springjdbc.JdbcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(SpringbootdemoApplicationTests.class);
    @Autowired
    private Service1 service1;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private User user;
    @Autowired
    private RedisObjectSerialier redisObjectSerialier;
    @Autowired
    private JdbcService jdbcService;

    @Test
    public void contextLoads() {
        service1.save1();
    }
    @Test
    public void testLog(){
        logger.error("ssss");
        logger.info("i am info");
        logger.warn("i am warm");
    }
    @Test
    public void redisString(){
        stringRedisTemplate.opsForValue().set("name","ougen");
        stringRedisTemplate.setHashValueSerializer(redisObjectSerialier);
//        Gson gson = new Gson();
//        String gsons = gson.toJson(user);
//        User user = (User) redisObjectSerialier.deserialize(stringRedisTemplate.opsForHash().get("userhash", "user").toString().getBytes());
//        stringRedisTemplate.opsForHash().put("userhash","user"+user.getUsername(),user);
        User user1 = (User) stringRedisTemplate.opsForHash().get("userhash","user"+user.getUsername());
        System.out.println(user1);
    }
    @Test
    public void JdbcTest(){
        System.out.println(jdbcService.getStudent());
    }
}
