package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.PmsProductAttribute;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeExample;

import java.util.List;

public interface PmsProductAttributeMapper {

    List<PmsProductAttribute> selectByExample(PmsProductAttributeExample example);

    int insertSelective(PmsProductAttribute pmsProductAttribute);

    PmsProductAttribute selectByPrimaryKey(Long aLong);

    int deleteByExample(PmsProductAttributeExample example);
}
