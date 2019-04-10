package com.neusoft.mall.usersettings.service.impl;

import com.neusoft.common.response.AppResponse;
import com.neusoft.common.util.CreateMD5;
import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.usersettings.mapper.AccountMapper;
import com.neusoft.mall.usersettings.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 13:13
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;


    @Override
    public AppResponse updatePassword(CustomerInfo customer) throws UnsupportedEncodingException {
        //判断密码是否为空
        if(null!= customer.getCustomerPassword()&& !"".equals(customer.getCustomerPassword())){
            //查找相应用户
            CustomerInfo checkCustomer = mapper.getCustomerById(customer.getCustomerId());
            if(null == checkCustomer){
                return AppResponse.bizError("用户不存在或者已经被删除！");
            }else if (!CreateMD5.getMd5(customer.getCustomerPassword()).
                    equals(checkCustomer.getCustomerPassword())){
                //若用户存在，且密码与当前密码不匹配
                return AppResponse.bizError("原密码不匹配，请重新输入");
            }else {
                //修改密码  写入数据库
                customer.setCustomerPassword(CreateMD5.getMd5(customer.getCustomerPassword()));
                int result = mapper.updatePassword(customer);
                if (0 == result) {
                    return AppResponse.bizError("修改密码失败，请重试！");
                }
                return AppResponse.success("修改密码成功！");
            }
        }else {
            //前端数据为空走这里！
            return AppResponse.bizError("未知数据错误！");
        }
    }


    /**
     * @Dept：大连东软信息学院
     * @Description： 用户登陆
     * @Author：xiaobai
     * @Date: 2019/4/9
     * @Param：customerNumber
        pwd
     * @Return：com.neusoft.mall.entity.UserInfo
     */
    @Override
    public CustomerInfo userLogin(String customerNumber, String pwd) throws UnsupportedEncodingException {
        return mapper.userLogin(customerNumber,CreateMD5.getMd5(pwd));
    }


}
