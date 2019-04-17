package com.neusoft.mall.customermanagement.service;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.entity.CustomerInfoVo;

/**
 * @Author: fanwenkai
 * @Description:
 * @Date: Create in 14:48 2019/4/9
 */
public interface CustomerManageService {
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户详情
     * @Author：fwk
     * @Date: 2019/4/15
     */
    CustomerInfo getCustomerDetail(String customerId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 添加客户
     * @Author：fwk
     * @Date: 2019/4/15
     */
    AppResponse addCustomer(CustomerInfo customerInfo);
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户启用/禁用
     * @Author：fwk
     * @Date: 2019/4/15
     */
    AppResponse updateAccountByStatus(CustomerInfo customerInfo);
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户修改
     * @Author：fwk
     * @Date: 2019/4/15
     */
    AppResponse updateAccount(CustomerInfo customerInfo);
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户查询
     * @Author：fwk
     * @Date: 2019/4/15
     */
    AppResponse getCustomerList(CustomerInfoVo customerInfoVo);
}
