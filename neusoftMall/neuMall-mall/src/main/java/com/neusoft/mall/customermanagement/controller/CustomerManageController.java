package com.neusoft.mall.customermanagement.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.customermanagement.service.CustomerManageService;
import com.neusoft.mall.customermanagement.util.StringUtil;
import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.entity.CustomerInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 14:46 2019/4/9
 */
@Slf4j
@RestController
@RequestMapping(value = "backend")
public class CustomerManageController {
    @Autowired
    CustomerManageService customerManageService;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取客户详情
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @RequestMapping(value = "customer/getCustomerDetail",method = RequestMethod.GET)
    public AppResponse getCustomerDetail(@PathParam("customerId") String customerId) throws Exception{
        System.out.print(customerId);
        CustomerInfo customer = null;
        try {
            customer=customerManageService.getCustomerDetail(customerId);
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
        String userId = "stt";
        customerInfo.setCustomerId(StringUtil.getUUID());
        customerInfo.setLastModifiedBy(userId);
        customerInfo.setCreatedBy(userId);
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
        String userId = "fwk";
        customerInfo.setLastModifiedBy(userId);
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
        String userId = "sst11";
        customerInfo.setLastModifiedBy(userId);
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
        System.out.print(customerInfoVo);
            AppResponse appResponse = customerManageService.getCustomerList(customerInfoVo);
            return appResponse;
    }

}
