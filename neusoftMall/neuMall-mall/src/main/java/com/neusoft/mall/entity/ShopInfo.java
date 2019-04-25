package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: ShopInfo
 * @Description:F小组
 * @Author: zhangqiang
 * @Description 实体类 购物车表
 * @Date: 2019/4/12
 */
@Data
public class ShopInfo extends BaseEntity {
    private String shopId;
    private String commodityId;
    private String shopNumber;
    private String customerId;
}

