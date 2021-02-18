package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsResourceCategory;
import com.macro.mall.tiny.mbg.model.UmsResourceCategoryExample;

import java.util.List;

public interface UmsResourceCategoryMapper {

    List<UmsResourceCategory> selectByExample(UmsResourceCategoryExample example);

    int insert(UmsResourceCategory umsResourceCategory);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UmsResourceCategory record);
}
