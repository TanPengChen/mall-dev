package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.PmsSkuStock;

import java.util.List;

public interface PmsSkuStockService {

    List<PmsSkuStock> getList(Long pid, String keyword);

    int update(Long pid, List<PmsSkuStock> skuStockList);
}
