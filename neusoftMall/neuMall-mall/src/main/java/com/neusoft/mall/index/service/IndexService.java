package com.neusoft.mall.index.service;

import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.entity.IndexQueryVO;


/**
 * @Author: xiaobai
 * @Date: 2019/4/8 17:45
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public interface IndexService {
    /**
     * 获取推荐商品列表
     * @param queryVO 分页和是否推荐
     * @return 结果
     */
    AppResponse getRecommondCommodityList(IndexQueryVO queryVO);

    /**
     * 获取用户已经买过的商品
     * @param customerId 用户ID
     * @return 结果
     */
    AppResponse getBuyCommodityList(String customerId);

    /**
     * 获取分类列表
     * 若参数为 0 返回一级分类列表
     * 若参数为一级分类ID 返回属于其的二级分类
     * @param categoryParentId 分类ID
     * @return 结果
     */
    AppResponse getClassifyList(String categoryParentId);
}
