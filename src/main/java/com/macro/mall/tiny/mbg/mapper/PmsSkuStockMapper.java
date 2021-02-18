package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.PmsSkuStock;
import com.macro.mall.tiny.mbg.model.PmsSkuStockExample;

import java.util.List;

public interface PmsSkuStockMapper {

    List<PmsSkuStock> selectByExample(PmsSkuStockExample pmsSkuStockExample);
}
