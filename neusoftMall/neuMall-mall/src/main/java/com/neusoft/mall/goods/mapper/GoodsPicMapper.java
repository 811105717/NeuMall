package com.neusoft.mall.goods.mapper;

import com.neusoft.mall.goods.entity.GoodsPic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsPicMapper {

    List<GoodsPic> selectAllByGoodsId(String goodsId);

    int insertSelective(GoodsPic record);

    int updateSelective(GoodsPic record);

    int insertGoodsPics(List<GoodsPic> record);

    int updateGoodsPic(List<GoodsPic> record);

    int deleteByCommodityId(String CommodityId);

}