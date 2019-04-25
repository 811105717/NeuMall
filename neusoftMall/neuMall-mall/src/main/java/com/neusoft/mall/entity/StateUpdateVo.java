package com.neusoft.mall.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: xiaobai
 * @Date: 2019/4/13 14:18
 * @email: baijinfeng1202@gmail.com
 * @address: 大连东软信息学院
 * @Description 辅助类 用于更新订单状态的包装类
 * @Version 1.0
 */
@Data
public class StateUpdateVo {
    private List<String> orderNumberList; //订单号列表
    private String orderState; //订单状态
    private String lastModifiedBy; //最后修改者

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

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}
