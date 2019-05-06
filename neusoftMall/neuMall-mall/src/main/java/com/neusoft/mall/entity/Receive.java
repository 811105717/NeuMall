package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

@Data
public class Receive extends BaseEntity {
    private String receiveId;
    private String regionProvince;
    private String regionCity;
    private String regionCounty;
    private String receiveDetailedAddress;
    private String receiveContact;
    private String receiveTel;
    private String receiveIsDefault;
    private String tokenFront;
    private String receiveAllAddress;

}
