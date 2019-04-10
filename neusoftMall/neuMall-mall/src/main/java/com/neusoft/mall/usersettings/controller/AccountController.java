package com.neusoft.mall.usersettings.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.usersettings.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:12
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/front/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * @Dept：大连东软信息学院
     * @Description：修改密码
     * @Author：xiaobai
     * @Date: 2019/4/9
     * @Param：customerId 客户ID
     *  customerNewPassword 新密码
     *  customerPassword 原密码
     * @Return：java.util.Map<java.lang.String,java.lang.Object>
     */
    @PutMapping(value = "updatePassWord")
    public AppResponse updatePassWord(CustomerInfo customer) throws Exception{
        try {
//            customer.setLastModifiedBy("xiaobai");
            return accountService.updatePassword(customer);
        } catch (UnsupportedEncodingException e) {
            log.info("error update password {}",e);
            throw new Exception("修改密码异常");
        }
    }

    @GetMapping(value = "userLogin")
    public Map<String,Object> userLogin(String customerNumber, String customerPassword,
                                        HttpServletRequest request) throws UnsupportedEncodingException {
        HashMap<String, Object> map = new HashMap<>(16);
        CustomerInfo loginUser = accountService.userLogin(customerNumber, customerPassword);
        if(null==loginUser){
            map.put("code",4);
            map.put("msg","用户登录失败，用户名或密码错误！");
            map.put("data","");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("_LOGIN_USER_",loginUser);
            map.put("code",0);
            map.put("msg","登录成功！");
            map.put("data","");
        }
        return  map;
    }

}
