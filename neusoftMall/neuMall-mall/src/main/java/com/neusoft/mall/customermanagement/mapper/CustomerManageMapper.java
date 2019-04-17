package com.neusoft.mall.customermanagement.mapper;

import com.neusoft.mall.entity.CustomerInfo;
import com.neusoft.mall.entity.CustomerInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 14:48 2019/4/9
 */
@Mapper
public interface CustomerManageMapper {
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取客户详情
     * @Author：fwk
     * @Date: 2019/4/13
     */
    public CustomerInfo getCustomerDetail(String customerId);
    /**
     * @Dept：大连东软信息学院
     * @Description： 添加客户
     * @Author：fwk
     * @Date: 2019/4/11
     */
    public int addCustomer(CustomerInfo customerInfo);
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户启用/禁用
     * @Author：fwk
     * @Date: 2019/4/15
     */
    public int updateAccountByStatus(CustomerInfo customerInfo);
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户修改
     * @Author：fwk
     * @Date: 2019/4/15
     */
    public int updateAccount(CustomerInfo customerInfo);
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户查询
     * @Author：fwk
     * @Date: 2019/4/15
     */
    public List<CustomerInfoVo> getCustomerList(CustomerInfoVo customerInfoVo);
}
