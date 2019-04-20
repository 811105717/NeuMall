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
public class RedisUtil {
    @Autowired
    private RedisTemplate redisTemplate;
    //数据存活时间
    private static final long ACTIVE_TIME = 30;

    /**
     * @Dept：大连东软信息学院
     * @Description： 向redis 中添加数据
     * @Author：xiaobai
     * @Date: 2019/4/20
     * @Param：key
     * @Return：boolean
     */

    public synchronized boolean addData(String key,Object value){
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
     * @Description： 取数据
     * @Author：xiaobai
     * @Date: 2019/4/20
     * @Param：key
     * @Return：java.lang.Object
     */
    public synchronized Object getData(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForValue().get(key);
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
    public synchronized boolean deleteData(String key){
        if(null == key){
            return false;
        }
        return redisTemplate.delete(key);
    }

    public static String generateToken(){
        return UUIDUtil.uuidStr();
    }
}
