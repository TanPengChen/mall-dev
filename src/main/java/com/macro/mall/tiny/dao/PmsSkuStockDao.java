package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsSkuStockDao {

    /**
     * 批量插入或替代操作
     * @param skuStockList
     * @return
     */
    int replaceList(@Param("list") List<PmsSkuStock> skuStockList);
}
