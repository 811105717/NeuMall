package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;

import lombok.Data;

@Data
public class Region extends BaseEntity {
    private String parentRegionID;
    private String regionId;
    private String regionType;
    private String regionName;
}
