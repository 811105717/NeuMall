package com.neusoft.mall.category.mapper;

import com.neusoft.mall.category.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {


    int deleteByPrimaryKey(Category record);


    List<Category> getCategory();

    List<Category> getCategoryName(String name);

    Category getCategoryParent(String parentId);

    int insertSelective(Category record);

    int insert(Category record);

    Category selectByPrimaryKey(String categoryId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}