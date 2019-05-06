package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 17:00
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description 实体类 对应商品表 t_commidity
 * @Version 1.0
 */
@Data
@SuppressWarnings("ALL")
public class CommodityInfo extends BaseEntity {
    /**
     * 商品编号
     */
    private String commodityCode;
    /**
     * 商品ID
     */
    private String commodityId;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 颜色
     */
    private String commodityColor;
    /**
     * 原价
     */
    private String commodityOriginalPrice;
    /**
     * 零售价
     */
    private String commodityRetailPrice;
    /**
     * 购买单位
     */
    private String commodityUnitId;
    /**
     * 是否上架 1是0否
     */
    private String commodityIsSold;
    /**
     * 库存
     */
    private String commodityInventory;
    /**
     * 是否缺货 1是0否
     */
    private String commodityIsLack;
    /**
     * 商品首图
     */
    private String commodityFirstPicture;
    /**
     * 销量
     */
    private String commodityTotalCount;
    /**
     * 一级分类ID
     */
    private String categoryFirst;
    /**
     * 二级分类ID
     */
    private String categorySecond;
    /**
     * 图片地址
     * 不再维护  替代属性是商品首图
     * commodityFirstPicture
     */
    @Deprecated
    private String pictureAddress;
   /**
    *数量排序
    */
    private String sortingTotalCount;
    /**
     *价格排序
     */
    private String sortingRetailPrice;

}
