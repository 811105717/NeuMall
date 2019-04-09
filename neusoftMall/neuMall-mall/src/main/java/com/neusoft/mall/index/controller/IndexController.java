package com.neusoft.mall.index.controller;

import com.neusoft.common.entity.BasePageVo;
import com.neusoft.mall.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:36
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/front/commodity")
public class IndexController {


    @Autowired
    private IndexService indexService;

    /**
     * @Dept：大连东软信息学院
     * @Description：获取用户买过的商品列表
     * @Author：xiaobai
     * @Date: 2019/4/9
     * @Param：customerId
     * @Return：java.util.Map<java.lang.String,java.lang.Object>
     */
    @GetMapping(value = "getBuyCommodityList")
    public Map<String,Object> getBuyCommodityList(String customerId){
        HashMap<String, Object> map = new HashMap<>(16);



        return map;
    }

}
