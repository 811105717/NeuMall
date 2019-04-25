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

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityColor() {
        return commodityColor;
    }

    public void setCommodityColor(String commodityColor) {
        this.commodityColor = commodityColor;
    }

    public String getCommodityOriginalPrice() {
        return commodityOriginalPrice;
    }

    public void setCommodityOriginalPrice(String commodityOriginalPrice) {
        this.commodityOriginalPrice = commodityOriginalPrice;
    }

    public String getCommodityRetailPrice() {
        return commodityRetailPrice;
    }

    public void setCommodityRetailPrice(String commodityRetailPrice) {
        this.commodityRetailPrice = commodityRetailPrice;
    }

    public String getCommodityUnitId() {
        return commodityUnitId;
    }

    public void setCommodityUnitId(String commodityUnitId) {
        this.commodityUnitId = commodityUnitId;
    }

    public String getCommodityIsSold() {
        return commodityIsSold;
    }

    public void setCommodityIsSold(String commodityIsSold) {
        this.commodityIsSold = commodityIsSold;
    }

    public String getCommodityInventory() {
        return commodityInventory;
    }

    public void setCommodityInventory(String commodityInventory) {
        this.commodityInventory = commodityInventory;
    }

    public String getCommodityIsLack() {
        return commodityIsLack;
    }

    public void setCommodityIsLack(String commodityIsLack) {
        this.commodityIsLack = commodityIsLack;
    }

    public String getCommodityFirstPicture() {
        return commodityFirstPicture;
    }

    public void setCommodityFirstPicture(String commodityFirstPicture) {
        this.commodityFirstPicture = commodityFirstPicture;
    }

    public String getCommodityTotalCount() {
        return commodityTotalCount;
    }

    public void setCommodityTotalCount(String commodityTotalCount) {
        this.commodityTotalCount = commodityTotalCount;
    }

    public String getCategoryFirst() {
        return categoryFirst;
    }

    public void setCategoryFirst(String categoryFirst) {
        this.categoryFirst = categoryFirst;
    }

    public String getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(String categorySecond) {
        this.categorySecond = categorySecond;
    }
}
