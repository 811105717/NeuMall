package com.neusoft.mall.backenuserlogin.service.impl;

import com.neusoft.common.entity.UserInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.backenuserlogin.mapper.UserMapper;
import com.neusoft.mall.backenuserlogin.service.UserService;
import com.neusoft.mall.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 15:27 2019/4/23
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public AppResponse userLongin(UserInfo userInfo, HttpServletRequest request) throws UnsupportedEncodingException {
        if(null != userInfo.getUserPwd()&& !"".equals(userInfo.getUserPwd()) ){
//            userInfo.setUserPwd(CreateMD5.getMd5(userInfo.getUserPwd()));
            UserInfo logInUser = userMapper.userLogin(userInfo);
            if (null == logInUser){
                //如果登陆失败  可能用户不存在  也可能密码错误
                return AppResponse.bizError("用户登录失败，用户名或密码错误！");
            }else {
                //放入token
                logInUser.setUserPwd(null);
                logInUser.setTokenBackend(RedisUtil.generateToken());
                boolean res1 = redisUtil.addData(logInUser.getTokenBackend(),logInUser);
                boolean res2 = redisUtil.updateActiveTime(logInUser.getTokenBackend());
                if(res1 && res2){
                    log.info("用户登陆成功  放入redis token {}",logInUser.getTokenBackend());
                    return AppResponse.success("用户登录成功！",logInUser);
                }
                return AppResponse.bizError("放入redis失败 拒绝登陆！");
            }
        }else {
            return AppResponse.bizError("未知数据错误！");
        }
    }
}
