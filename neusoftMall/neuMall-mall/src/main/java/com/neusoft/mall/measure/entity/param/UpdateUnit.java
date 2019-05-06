package com.neusoft.mall.measure.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class UpdateUnit {
    private String unitName;
    private String unitId;
    private int version;
    private String tokenBackend;
    // private CustomerInfo customer;
}
