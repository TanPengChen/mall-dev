package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductFullReductionDao {

    /**
     *批量创建
     * @param productFullReductionList
     * @return
     */
    int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
