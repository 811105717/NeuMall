package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: xiaobai
 * @Date: 2019/4/9 17:00
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description 实体类 对应商品表
 * @Version 1.0
 */
@Data
public class CommodityInfo extends BaseEntity {
    private String commodityCode; //商品编号
    private String commodityId; //商品ID
    private String commodityName; //商品名称
    private String commodityColor; //颜色
    private String commodityOriginalPrice; //原价
    private String commodityRetailPrice; //零售价
    private String commodityUnitId; //购买单位
    private String commodityIsSold; //是否上架 1是0否
    private String commodityInventory; //库存
    private String commodityIsLack; //是否缺货 1是0否
    private String commodityFirstPicture;//商品首图
    private String commodityTotalCount; //销量
    private String categoryFirst; //一级分类ID
    private String categorySecond; //二级分类ID
}
