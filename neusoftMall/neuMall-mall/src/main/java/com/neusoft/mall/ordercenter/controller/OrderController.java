package com.neusoft.mall.ordercenter.controller;

import com.neusoft.mall.ordercenter.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:49
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/front/orderCenter")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value="getOrderList")
    public Map<String,Object> getOrderList(){
        HashMap<String, Object> map = new HashMap<>(16);

        return map;
    }
}
