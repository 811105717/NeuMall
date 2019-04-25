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
public class TradinInfo extends BaseEntity{
    private String customerId;
    private String customerName;
    private String commodityRetailPrice;
    private String shopNumber;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCommodityRetailPrice() {
        return commodityRetailPrice;
    }

    public void setCommodityRetailPrice(String commodityRetailPrice) {
        this.commodityRetailPrice = commodityRetailPrice;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber;
    }
}

