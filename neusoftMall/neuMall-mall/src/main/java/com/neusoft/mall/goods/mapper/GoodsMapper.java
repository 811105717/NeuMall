package com.neusoft.mall.goods.mapper;

import com.neusoft.mall.goods.entity.Goods;
import com.neusoft.mall.goods.entity.param.getGoodsPageParam;
import com.neusoft.mall.goods.entity.returnParam.GoodsReturn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    GoodsReturn selectGoodsById(String commodityId);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String commodityId);

    int updateByPrimaryKeySelective(Goods record);

    int deleteGoods(String commodityId);

    List<Goods> getGoodsPage(getGoodsPageParam pageParam);
}