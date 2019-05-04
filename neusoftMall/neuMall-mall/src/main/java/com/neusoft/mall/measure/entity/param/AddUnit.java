package com.neusoft.mall.measure.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class AddUnit {
    private String unitName;
    private String tokenBackend;
    private CustomerInfo customer;
}
