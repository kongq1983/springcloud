package com.kq.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.ZParams;

import java.util.UUID;

/**
 * RateLimiterTest
 *
 * @author kq
 * @date 2018-12-29
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisConfiguration.class)
public class RateLimiterTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JedisPool jedisPool;

    private static final String BUCKET = "BUCKET_";
    private static final String BUCKET_COUNT = "BUCKET_COUNT";
    private static final String BUCKET_MONITOR = "BUCKET_MONITOR_";


    @Test
    public void test(){

        String point = "hello";
        int limit = 100;
        long timeout = 1000;

        Jedis jedis = jedisPool.getResource();
        //UUID令牌
        String token = UUID.randomUUID().toString();
        long now = System.currentTimeMillis();
        //开启事务
        Transaction transaction = jedis.multi();

        //删除信号量 移除有序集中指定区间(score)内的所有成员 ZREMRANGEBYSCORE key min max
        long diff = now - timeout;
        logger.info("diff={}",diff);
        // -inf 最小无穷  删除最小值 到 过期前的值 全部删除
        transaction.zremrangeByScore((BUCKET_MONITOR + point).getBytes(), "-inf".getBytes(), String.valueOf(diff).getBytes());
        //为每个有序集分别指定一个乘法因子(默认设置为 1) 每个成员的score值在传递给聚合函数之前都要先乘以该因子
        ZParams params = new ZParams();
        params.weightsByDouble(1.0, 0.0);
        //计算给定的一个或多个有序集的交集
        transaction.zinterstore(BUCKET + point, params, BUCKET + point, BUCKET_MONITOR + point);

        //计数器自增
        transaction.incr(BUCKET_COUNT);


        System.out.println("jedisPool="+jedisPool);
    }

}
