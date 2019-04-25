package com.neusoft.mall.customermanagement.controller;

import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.entity.UserInfo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.customermanagement.service.CustomerManageService;
import com.neusoft.mall.customermanagement.util.StringUtil;
import com.neusoft.mall.entity.CustomerInfoVo;
import com.neusoft.mall.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 14:46 2019/4/9
 */
@Slf4j
@RestController
@RequestMapping(value = "/backend")
@CrossOrigin
public class CustomerManageController {
    @Autowired
    CustomerManageService customerManageService;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取客户详情
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @RequestMapping(value = "customer/getCustomerDetail",method = RequestMethod.GET)
    public AppResponse getCustomerDetail(@RequestBody CustomerInfo customerInfo) throws Exception{
        if(null == customerInfo.getTokenBackend()){
            return AppResponse.bizError("token失效");
        }
        UserInfo user = (UserInfo) redisUtil.getData(customerInfo.getTokenBackend());
        CustomerInfo customer = null;
        try {
            customer=customerManageService.getCustomerDetail(customerInfo.getCustomerId());
        } catch (Exception e) {
            log.error("客户查询错误", e);
            throw new Exception("查询错误，请重试");
        }
        if (customer == null) {
            return AppResponse.notFound("无查询结果");
        }
        return AppResponse.success("查询成功", customer);
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 添加客户
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @RequestMapping(value = "customer/addCustomer",method = RequestMethod.POST)
    public AppResponse addCustomer(@RequestBody CustomerInfo customerInfo) throws Exception {
        //获取用户id   TODO  应该从session中获取,暂时写死

        if(null == customerInfo.getTokenBackend()){
            return AppResponse.bizError("token失效");
        }
        UserInfo user = (UserInfo) redisUtil.getData(customerInfo.getTokenBackend());
        customerInfo.setLastModifiedBy(user.getUserName());
        System.out.print(user.getUserName());
        customerInfo.setCustomerId(StringUtil.getUUID());
        customerInfo.setLastModifiedBy(user.getUserName());
        customerInfo.setCreatedBy(user.getUserName());
        System.out.print("用户新增"+customerInfo);
        try {
            AppResponse appResponse = customerManageService.addCustomer(customerInfo);
            return appResponse;
        } catch (Exception e) {
            log.error("用户新增失败", e);
            throw new Exception("用户新增失败，请重试");
        }
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户禁用/启用
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @PutMapping(value = "customer/updateAccountByStatus")
    public AppResponse updateAccountByStatus(@RequestBody CustomerInfo customerInfo) throws Exception {
        if(null == customerInfo.getTokenBackend()){
            return AppResponse.bizError("token失效");
        }
        UserInfo user = (UserInfo) redisUtil.getData(customerInfo.getTokenBackend());
        customerInfo.setLastModifiedBy(user.getUserName());
        System.out.print(user.getUserName());
        if(customerInfo.getCustomerIsUsed().equals("1")){
            customerInfo.setCustomerIsUsed("0");
        }else{
            customerInfo.setCustomerIsUsed("1");
        }
        System.out.print(customerInfo);
        try {
            AppResponse appResponse = customerManageService.updateAccountByStatus(customerInfo);
            return appResponse;
        } catch (Exception e) {
            log.error("用户修改失败", e);
            throw new Exception("用户修改失败，请重试");
        }
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户修改
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @PutMapping(value = "customer/updateAccount")
    public AppResponse updateAccount(@RequestBody CustomerInfo customerInfo) throws Exception {
        if(null == customerInfo.getTokenBackend()){
            return AppResponse.bizError("token失效");
        }
        UserInfo user = (UserInfo) redisUtil.getData(customerInfo.getTokenBackend());
        customerInfo.setLastModifiedBy(user.getUserName());
        System.out.print(customerInfo);
        try {
            AppResponse appResponse = customerManageService.updateAccount(customerInfo);
            return appResponse;
        } catch (Exception e) {
            log.error("用户修改失败", e);
            throw new Exception("用户修改失败，请重试");
        }
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户查询
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @GetMapping(value = "customer/getCustomerList")
    public AppResponse getCustomerList(CustomerInfoVo customerInfoVo) throws Exception {
        if(null == customerInfoVo.getTokenBackend()){
            return AppResponse.bizError("token失效");
        }
        UserInfo user = (UserInfo) redisUtil.getData(customerInfoVo.getTokenBackend());
        System.out.print(user);
            AppResponse appResponse = customerManageService.getCustomerList(customerInfoVo);
            return appResponse;
    }

}
