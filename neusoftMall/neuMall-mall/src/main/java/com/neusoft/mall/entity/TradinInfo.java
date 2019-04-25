package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: TradinInfo
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/18
 */
@Data
public class TradinInfo extends BaseEntity {
    private String customerId;
    private String customerName;
    private String commodityPrice;
    private String commodityNum;
}