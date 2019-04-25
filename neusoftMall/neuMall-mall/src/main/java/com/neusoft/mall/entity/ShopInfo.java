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
    private String shop_number;
    private String customerId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getShop_number() {
        return shop_number;
    }

    public void setShop_number(String shop_number) {
        this.shop_number = shop_number;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}

