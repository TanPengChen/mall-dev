package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.PmsProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义价格阶梯dao
 */
public interface PmsProductLadderDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<PmsProductLadder> productLadderList);
}
