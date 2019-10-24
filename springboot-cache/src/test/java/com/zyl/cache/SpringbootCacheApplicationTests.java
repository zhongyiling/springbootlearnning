package com.zyl.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {
    @Autowired
   StringRedisTemplate stringredisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void test01(){
        stringredisTemplate.opsForValue().set("mes","hello");
        String message = stringredisTemplate.opsForValue().get("mes");
        System.out.println(message);
    }

    @Test
    public void contextLoads() {
    }

}
