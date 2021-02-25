package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductAttributeValueDao {

    /**
     * 批量创建
     */
    int insertList(@Param("list")List<PmsProductAttributeValue> productAttributeValueList);
}
