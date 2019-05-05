package com.neusoft.mall.backenuserlogin.controller;

import com.neusoft.common.entity.UserInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.backenuserlogin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 15:21 2019/4/23
 */
@Slf4j
@RestController
@RequestMapping("/backend")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login/userLogin",method = RequestMethod.POST)
    public AppResponse userLogin(@RequestBody UserInfo userInfo, HttpServletRequest request) throws Exception{
        log.info("userLogin Backend {}",userInfo);
        try {
            return userService.userLongin(userInfo,request);
        } catch (UnsupportedEncodingException e){
            log.info("error register customer {}",e);
            throw new Exception("用户登录异常");
        }
    }

}
