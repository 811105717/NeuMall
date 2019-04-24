package com.neusoft.mall.customermanagement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.common.entity.CustomerInfo;
import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.customermanagement.mapper.CustomerManageMapper;
import com.neusoft.mall.customermanagement.service.CustomerManageService;
import com.neusoft.mall.entity.CustomerInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: linmeng
 * @Description:
 * @Date: Create in 14:49 2019/4/9
 */
@Service
public class CustomerServiceImpl implements CustomerManageService {
    @Resource
    CustomerManageMapper customerManageMapper;
    /**
     * @Dept：大连东软信息学院
     * @Description： 获取客户详情
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @Override
    public CustomerInfo getCustomerDetail(String customerId) {
        CustomerInfo customer=customerManageMapper.getCustomerDetail(customerId);
        return customer;
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 新增客户
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @Override
    public AppResponse addCustomer(CustomerInfo customerInfo){
        // 新增用户
        int result=customerManageMapper.addCustomer(customerInfo);
        System.out.print("新增用户"+customerInfo);
        if (0 == result) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * @Dept：大连东软信息学院
     * @Description： 客户启用/禁用
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @Override
    public AppResponse updateAccountByStatus(CustomerInfo customerInfo) {
        int result=customerManageMapper.updateAccountByStatus(customerInfo);
        if (0 == result) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }
    /**
     * @Dept：大连东软信息学院
     * @Description：客户修改
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @Override
    public AppResponse updateAccount(CustomerInfo customerInfo) {
        int result=customerManageMapper.updateAccount(customerInfo);
        if (0 == result) {
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 客户查询
     * @Author：fwk
     * @Date: 2019/4/15
     */
    @Override
    public AppResponse getCustomerList(CustomerInfoVo customerInfoVo) {
        //处理分页
        PageVo<CustomerInfoVo> list = new PageVo<>();
        PageHelper.startPage(customerInfoVo.getPageNum(),customerInfoVo.getPageSize());
        List<CustomerInfoVo> customerList = customerManageMapper.getCustomerList(customerInfoVo);
        list.setList(customerList);
        list.setTotalRecords((int)new PageInfo<>(customerList).getTotal());
        //获取数据成功！
        if(0<list.getTotalRecords()){
            return AppResponse.success("订单获取成功！",list);
        }else {
            return AppResponse.notFound("未查询到数据！");
        }
    }
}
