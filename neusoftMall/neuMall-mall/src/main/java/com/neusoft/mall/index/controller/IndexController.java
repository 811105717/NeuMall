package com.neusoft.mall.index.controller;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.IndexQueryVO;
import com.neusoft.mall.index.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
@RestController
@RequestMapping(value = "/front/commodity")
@Api("首页API")
@Slf4j
public class IndexController {
    /**
     * 首页信息服务层
     */
    @Autowired
    private IndexService indexService;

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取热门推荐商品
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：queryVO 分页 和是否推荐
     * @Return：com.neusoft.common.response.AppResponse 结果
     */
    @ApiOperation("获取用户推荐列表")
    @GetMapping(value = "getRecommondCommodityList")
    public AppResponse getRecommondCommodityList(IndexQueryVO queryVO){
        log.info("getRecommondCommodityList frontData {}",queryVO);
        return indexService.getRecommondCommodityList(queryVO);
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 获取用户买过的商品
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：customerId 用户ID
     * @Return：com.neusoft.common.response.AppResponse 结果
     */
    @ApiOperation("获取用户买过的订单列表")
    @GetMapping(value = "getBuyCommodityList")
    public AppResponse getBuyCommodityList(String tokenFront){
        log.info("getBuyCommodityList frontData {}",tokenFront);
        return indexService.getBuyCommodityList(tokenFront);
    }

    /**
     * @Dept：大连东软信息学院
     * @Description： 根据父级分类ID获取二级分类，若父分类ID为 0 查询一级
     * @Author：xiaobai
     * @Date: 2019/4/13
     * @Param：categoryParentId 父分类
     * @Return：com.neusoft.common.response.AppResponse
     */
    @ApiOperation("根据一级分类查询二级分类列表")
    @GetMapping(value = "getClassifyList")
    public AppResponse getClassifyList(String categoryParentId){
        log.info("getClassifyList frontData {}",categoryParentId);
        return indexService.getClassifyList(categoryParentId);
    }
}
