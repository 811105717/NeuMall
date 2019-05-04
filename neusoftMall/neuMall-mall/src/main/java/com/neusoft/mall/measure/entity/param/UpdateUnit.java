package com.neusoft.mall.measure.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class UpdateUnit {
    String unitName;
    String unitId;
    int version;
    private String tokenBackend;
    private CustomerInfo customer;
}
