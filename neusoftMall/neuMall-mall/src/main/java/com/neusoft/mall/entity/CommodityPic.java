package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;

/**
 * @ClassName: CommodityPic
 * @Description:F小组
 * @Author: zhangqiang
 * @Description 实体类 对应商品图片
 * @Date: 2019/4/12
 */
public class CommodityPic extends BaseEntity{
    private String pictureId;
    private String pictureAddress;
    private String pictureIsFistPicture;
    private String commodityId;

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getPictureIsFistPicture() {
        return pictureIsFistPicture;
    }

    public void setPictureIsFistPicture(String pictureIsFistPicture) {
        this.pictureIsFistPicture = pictureIsFistPicture;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }
}

