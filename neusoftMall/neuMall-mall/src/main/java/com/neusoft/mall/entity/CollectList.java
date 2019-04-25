package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

/**
 * @ClassName: CollectList
 * @Description:F小组
 * @Author: zhangqiang
 * @Date: 2019/4/18
 */
@Data
public class CollectList extends BaseEntity {
    private String customerId;
    private String commodityId;
    private String commodityFirstPicture;
    private String commodityName;
    private String commodityRetailPrice;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityFirstPicture() {
        return commodityFirstPicture;
    }

    public void setCommodityFirstPicture(String commodityFirstPicture) {
        this.commodityFirstPicture = commodityFirstPicture;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityRetailPrice() {
        return commodityRetailPrice;
    }

    public void setCommodityRetailPrice(String commodityRetailPrice) {
        this.commodityRetailPrice = commodityRetailPrice;
    }
}

