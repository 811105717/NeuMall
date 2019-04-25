package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 22:17 2019/4/11
 */
@Data
public class CommodityListInfo extends BaseEntity {
    private String pictureAddress;
    private String commodityName;
    private String commodityCode;
    private String commodityFirstPicture;
    private String commodityPrice;
    private String commodityNum;
    private String commodityTotalPrice;

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityFirstPicture() {
        return commodityFirstPicture;
    }

    public void setCommodityFirstPicture(String commodityFirstPicture) {
        this.commodityFirstPicture = commodityFirstPicture;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(String commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getCommodityTotalPrice() {
        return commodityTotalPrice;
    }

    public void setCommodityTotalPrice(String commodityTotalPrice) {
        this.commodityTotalPrice = commodityTotalPrice;
    }
}
