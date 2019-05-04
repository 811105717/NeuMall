package com.neusoft.mall.measure.entity.param;

import com.neusoft.common.entity.CustomerInfo;
import lombok.Data;

@Data
public class DeleteUnit {
    String unitId;
    private String tokenBackend;
    private CustomerInfo customer;
}
