package com.kq.redis.service;

/**
 * IRedisService
 *
 * @author1 kq
 * @date 2018-11-30
 */
public interface IRedisService {

    /**
     * 设置
     * @param key
     * @param value
     */
    public void set(String key,String value);

    /**
     * 获取value
     * @param key
     * @return
     */
    public String get(String key);

}
