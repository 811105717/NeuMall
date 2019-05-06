package com.neusoft.mall.goods.service;

import com.neusoft.common.entity.PageVo;
import com.neusoft.common.response.AppResponse;
import com.neusoft.mall.goods.entity.Goods;
import com.neusoft.mall.goods.entity.param.*;
import com.neusoft.mall.goods.entity.returnParam.GoodsReturn;

import java.util.Map;

public interface GoodsService {
    /**
     * 添加商品
     * @param Goods 添加商品的参数
     * @return 更新的条数
     */
    AppResponse addGoods(AddGoods Goods);

    /**
     * 修改商品信息
     * @param alterGoods 客户端传递修改商品的参数
     * @return 更新条数
     */
    AppResponse AlterGoods(AlterGoods alterGoods);

    /**
     * 删除商品信息
     * @param commodityId 商品id
     * @return 更新条数
     */
    AppResponse deleteGoods(DeleteGoods deleteGoods);

    /**
     * 更新商品上架与下架
     * @param params 商品上架下架参数
     * @return 更新条数
     */
    AppResponse updateGoodsIsSell(UpdateIsSell params);

    /**
     * 单个商品的详细信息
     * @param commodityId 商品id
     * @return 单个商品信息
     */
    GoodsReturn getGoodsDetail(GetGoodsDetail goodsDetail);

    /**
     * 分页获取商品列表
     * @param pageParam 分页参数
     * @return 分页的商品列表
     */
    PageVo<Goods> getGoodsPage(getGoodsPageParam pageParam);

    /**
     * 上传图片
     * @param param 图片参数
     * @return 图片地址
     */
    Map<String, String> uploadFile(Map<String, Object> param);

}
