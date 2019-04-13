package com.neusoft.mall.index.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.IndexQueryVO;
import com.neusoft.mall.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:36
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "/front/commodity")
public class IndexController {


    @Autowired
    private IndexService indexService;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取热门推荐商品
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：queryVO 分页 和是否推荐
     * @Return：com.neusoft.common.response.AppResponse
     */
    @GetMapping(value = "getRecommondCommodityList")
    public AppResponse getRecommondCommodityList(IndexQueryVO queryVO){
        return indexService.getRecommondCommodityList(queryVO);
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取用户买过的商品
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：customerId
     * @Return：com.neusoft.common.response.AppResponse
     */
    @GetMapping(value = "getBuyCommodityList")
    public AppResponse getBuyCommodityList(String customerId){
        return indexService.getBuyCommodityList(customerId);
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 根据父级分类获取二级分类
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：categoryParentId
     * @Return：com.neusoft.common.response.AppResponse
     */
    @GetMapping(value = "getClassifyList")
    public AppResponse getClassifyList(String categoryParentId){
        return indexService.getClassifyList(categoryParentId);
    }
}
