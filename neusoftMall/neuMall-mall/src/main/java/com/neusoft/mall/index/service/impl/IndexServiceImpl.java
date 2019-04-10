package com.neusoft.mall.index.service.impl;

import com.neusoft.mall.entity.OrderInfo;
import com.neusoft.mall.index.mapper.IndexMapper;
import com.neusoft.mall.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:46
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;

    /**
     * @Dept：大连东软信息学院
     * @Description：根据用户id获取用户订单列表
     * @Author：xiaobai
     * @Date: 2019/4/9
     * @Param：customerId
     * @Return：java.util.List<com.neusoft.mall.entity.OrderInfo>
     */
    @Override
    public List<OrderInfo> getCustomerOrderListByCustomerId(String customerId) {
        return indexMapper.getCustomerOrderListByCustomerId(customerId);
    }
}
