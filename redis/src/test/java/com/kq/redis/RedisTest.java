package com.kq.redis;

import com.kq.redis.service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;



/**
 * RedisTest
 *
 * @author kq
 * @date 2018-11-30
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = RedisConfiguration.class)

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisConfiguration.class)
public class RedisTest {

    @Autowired
    private IRedisService redisService;

//    main

    @Test
    public void test(){
        String key = "name";

        redisService.set(key,"king");

        String value = redisService.get(key);

        assertEquals(value,"king");

    }


}
