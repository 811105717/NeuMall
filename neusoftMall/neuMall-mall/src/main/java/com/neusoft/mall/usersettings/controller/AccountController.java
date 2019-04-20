package com.neusoft.mall.usersettings.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.usersettings.service.AccountService;
import com.neusoft.mall.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:12
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("All")
@Slf4j
@RestController
@RequestMapping("/front/account")
@Api("账户设置PAI")
@CrossOrigin
public class AccountController {
    private static final String LAST_MODIFIED_BY = "xiaobai";
    @Autowired
    private AccountService accountService;

    /**
     * @Dept：大连东软信息学院
     * @Description：修改密码
     * @Author：xiaobai
     * @Date: 2019/4/10
     * @Param：customer 客户实体对象
     * @Return：com.neusoft.common.response.AppResponse
     */
    @ApiOperation("修改密码")
    @PutMapping(value = "updatePassWord")
    public AppResponse updatePassWord(CustomerInfo customer) throws Exception{
        log.info("cust:{}",customer);
        try {
            customer.setLastModifiedBy(LAST_MODIFIED_BY);
            return accountService.updatePassword(customer);
        } catch (UnsupportedEncodingException e) {
            log.info("error update password {}",e);
            throw new Exception("修改密码异常");
        }
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 用户注册
     * @Author：xiaobai
     * @Date: 2019/4/10
     * @Param：customer 用户实体对象
     * @Return：com.neusoft.common.response.AppResponse
     */
    @ApiOperation("用户注册")
    @PostMapping(value = "registered")
    public AppResponse customerRegister(CustomerInfo customer) throws Exception{
        customer.setLastModifiedBy(LAST_MODIFIED_BY);
        try {
            return accountService.customerRegister(customer);
        } catch (UnsupportedEncodingException e) {
            log.info("error register customer {}",e);
            throw new Exception("用户注册异常");
        }
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 用户登录
     * @Author：xiaobai
     * @Date: 2019/4/10
     * @Param：customer 用户实体
     * @Return：com.neusoft.common.response.AppResponse
     */
    @ApiOperation("用户登录")
    @GetMapping(value = "userLogin")
    public AppResponse customerLogin(CustomerInfo customer,
                                     HttpServletRequest request) throws Exception{
        try {
            return accountService.customerLogin(customer,request);
        } catch (UnsupportedEncodingException e) {
            log.info("error register customer {}",e);
            throw new Exception("用户登录异常");
        }
    }

}
