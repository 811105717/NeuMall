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
public interface IndexService {
    AppResponse getRecommondCommodityList(IndexQueryVO queryVO);
    AppResponse getBuyCommodityList(String customerId);
    AppResponse getClassifyList(String categoryParentId);
}
