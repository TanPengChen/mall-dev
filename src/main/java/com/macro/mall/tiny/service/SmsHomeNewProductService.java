package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsHomeNewProduct;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 11:10
 */

public interface SmsHomeNewProductService {

    List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageNum, Integer pageSize);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    int updateSort(Long id, Integer sort);

    int create(List<SmsHomeNewProduct> smsHomeNewProduct);

    int delete(List<Long> ids);

}
