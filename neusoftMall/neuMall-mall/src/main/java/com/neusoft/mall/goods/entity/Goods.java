package com.neusoft.mall.goods.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Goods {
    private String commodityId;

    private String commodityCode;

    private String commodityName;

    private String commodityColor;

    private String commodityFirstPicture;

    private Long commodityOriginalPrice;

    private Long commodityRetailPrice;

    private String commodityUnitId;

    private Integer commodityIsSold;

    private Integer commodityInventory;

    private Integer commodityIsLack;

    private Integer commodityTotalcount;

    private Integer commodityIsRecommend;

    private String categoryFirst;

    private String categorySecond;

    private String createdBy;

    private Date gmtCreate;

    private String lastModifiedBy;

    private Date gmtModified;

    private Integer isDeleted;

    private Integer sortNo;

    private Integer version;

    private String commodityDesc;
}