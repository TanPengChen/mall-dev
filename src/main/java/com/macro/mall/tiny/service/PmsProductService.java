package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.PmsProductQueryParam;
import com.macro.mall.tiny.mbg.model.PmsProduct;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/17 10:06
 */

public interface PmsProductService {

    List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageNum,Integer pageSize);

    int newStatus(List<Long> ids, Integer newStatus);

    int publishStatus(List<Long> ids, Integer publishStatus);

    int recommendStatus(List<Long> ids, Integer recommendStatus);
}
