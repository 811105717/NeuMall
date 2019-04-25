package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author: fwk
 * @Description:
 * @Date: Create in 11:59 2019/4/12
 */
@Data
public class OrderNumberListInfo extends BaseEntity {
    private List<String> orderNumberList;//订单号列表
    private String orderState;//订单状态

    public List<String> getOrderNumberList() {
        return orderNumberList;
    }

    public void setOrderNumberList(List<String> orderNumberList) {
        this.orderNumberList = orderNumberList;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}
