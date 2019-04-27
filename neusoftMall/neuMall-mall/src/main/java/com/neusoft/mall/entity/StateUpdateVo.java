package com.neusoft.mall.entity;

import com.neusoft.common.entity.BaseEntity;
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
public class StateUpdateVo extends BaseEntity {
    /**
     * 订单号列表
     */
    private List<String> orderNumberList;
    /**
     * 订单状态
     */
    private String orderState;

}
