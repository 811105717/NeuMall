package com.neusoft.mall.usersettings.controller;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.usersettings.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:12
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("All")
@CrossOrigin
@RestController
@RequestMapping("/front/account")
@Api("账户设置PAI")
@Slf4j
public class AccountController {

    /**
     * 账户服务对象
     */
    @Autowired
    private AccountService accountService;

    /**
     * @Dept 大连东软信息学院
     * @Description 修改密码
     * @author xiaobai
     * @date 2019/4/10
     * @param customer 客户实体对象
     * @return com.neusoft.common.response.AppResponse
     */
    @ApiOperation("修改密码")
    @PutMapping(value = "updatePassWord")
    public AppResponse updatePassWord(CustomerInfo customer){
        log.info("updatePassWord frontData :{}",customer);
        try {
            return accountService.updatePassword(customer);
        } catch (UnsupportedEncodingException e) {
            log.info("error update password {}",e);
            return AppResponse.bizError("修改密码异常 不支持的编码");
        }
    }

    /**
     * @Dept 大连东软信息学院
     * @Description  用户注册
     * @author xiaobai
     * @date 2019/4/10
     * @param customer 用户实体对象
     * @return com.neusoft.common.response.AppResponse
     */
    @ApiOperation("用户注册")
    @PostMapping(value = "registered")
    public AppResponse customerRegister(CustomerInfo customer){
        log.info("registered frontData {}",customer);
        try {
            return accountService.customerRegister(customer);
        } catch (UnsupportedEncodingException e) {
            log.info("error register customer {}",e);
            return AppResponse.bizError("用户注册异常 不支持的编码");
        }
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 用户登录
     * @author xiaobai
     * @date 2019/4/10
     * @param customer 用户实体
     * @return com.neusoft.common.response.AppResponse
     */
    @ApiOperation("用户登录")
    @PostMapping(value = "userLogin")
    public AppResponse customerLogin(CustomerInfo customer){
        log.info("userLogin frontData {}",customer);
        try {
            return accountService.customerLogin(customer);
        } catch (UnsupportedEncodingException e) {
            log.info("error register customer {}",e);
            return AppResponse.bizError("用户登录异常 不支持的编码");
        }
    }

}
