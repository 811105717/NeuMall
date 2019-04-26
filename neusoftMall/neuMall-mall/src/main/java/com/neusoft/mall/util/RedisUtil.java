package com.neusoft.mall.util;

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
 * @Version 1.0
 */
@Component
@Slf4j
//@Deprecated
public class RedisUtil<T> {

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 数据存活时间
     */
    private static final long ACTIVE_TIME = 30;

    /**
     * @Dept：大连东软信息学院
     * @Description： 用于向redis中添加一条数据，返回结果表示是否添加成功
     * @Author：xiaobai
     * @Date: 2019/4/20
     * @Param：key 键值
     * @Return：boolean
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
     * @Dept：大连东软信息学院
     * @Description： 从redis中根据key取出一条数据 返回类型为Object
     * @Author：xiaobai
     * @Date: 2019/4/20
     * @Param：key 键值
     * @Return：java.lang.Object
     */
    public  T getData(String key){
        if(null == key){
            return null;
        }
        return (T)redisTemplate.opsForValue().get(key);
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 更新数据时间
     * @Author：xiaobai
     * @Date: 2019/4/20
     * @Param：key
     * @Return：boolean
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
     * @Dept：大连东软信息学院
     * @Description： 删除数据5t4rf
     * @Author：xiaobai
     * @Date: 2019/4/20
     * @Param：key
     * @Return：boolean
     */
    public  boolean deleteData(String key){
        if(null == key){
            return false;
        }
        return redisTemplate.delete(key);
    }

    public static String generateToken(){
        return UUIDUtil.uuidStr();
    }
}
