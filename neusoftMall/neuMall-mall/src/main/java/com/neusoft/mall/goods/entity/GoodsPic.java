package com.neusoft.mall.goods.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GoodsPic {
    private Integer pictureId;

    private String pictureAddress;

    private Integer pictureIsFistPictuer;

    private String commodityId;

    private String createdBy;

    private Date gmtCreate;

    private String lastModifiedBy;

    private Date gmtModified;

    private Integer isDeleted;

    private Integer sortNo;

    private Integer version;
}