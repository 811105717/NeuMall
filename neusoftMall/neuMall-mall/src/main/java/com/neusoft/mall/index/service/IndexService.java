package com.neusoft.mall.index.service;

import com.neusoft.mall.entity.OrderInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:45
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
public interface IndexService {
    List<OrderInfo> getCustomerOrderListByCustomerId(String customerId);
}
