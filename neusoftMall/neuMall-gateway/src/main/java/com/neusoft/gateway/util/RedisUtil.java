package com.neusoft.gateway.util;


import com.neusoft.common.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xiaobai
 * @Date: 2019/4/20 19:03
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @descripton 对redis操作进行封装 方便使用
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@Component
@Slf4j
public class RedisUtil<T> {

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 数据存活时间
     */
    private static final long ACTIVE_TIME = 30;

    /**
     * 添加一条数据
     * @param key 键
     * @param value 值
     * @return 添加结果
     */
    public  boolean addData(String key,T value){
        if(null == key){
            return false;
        }
        ValueOperations valueOperations = redisTemplate.opsForValue();
        if(null == valueOperations){
            return false;
        }
        valueOperations.set(key,value,RedisUtil.ACTIVE_TIME, TimeUnit.MINUTES);
        return true;
    }

    /**
     * 获取一条数据
     * @param key 键
     * @return 获取到的结果 没有返回null
     */
    public  T getData(String key){
        if(null == key){
            return null;
        }
        return (T)redisTemplate.opsForValue().get(key);
    }

    /**
     * 更新存活时间
     * @param key 被更新的键
     * @return  更新结果
     */
    public synchronized boolean updateActiveTime(String key){
        if(null == key){
            return false;
        }
        if(null == getData(key)){
            return false;
        }
        return redisTemplate.expire(key,RedisUtil.ACTIVE_TIME,TimeUnit.MINUTES);
    }

    /**
     * 删除一条数据
     * @param key 被删除的键
     * @return 删除结果
     */
    public  boolean deleteData(String key){
        if(null == key){
            return false;
        }
        return redisTemplate.delete(key);
    }

    /**
     * 生成一个UUID键
     * @return uuid
     */
    public static String generateToken(){
        return UUIDUtil.uuidStr();
    }
}
