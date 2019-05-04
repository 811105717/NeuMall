package com.neusoft.mall.measure.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Measure {
    private String unitId;

    private String unitName;

    private String createdBy;

    private Date gmtCreate;

    private String lastModifiedBy;

    private Date gmtModified;

    private Integer isDeleted;

    private Integer sortNo;

    private Integer version;
}