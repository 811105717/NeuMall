package com.neusoft.mall.entity;

import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
public class GetCommodityVo {
    private List<TradinInfo> commodityList;
    private  String tokenFront;
}
