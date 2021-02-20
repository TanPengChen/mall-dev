package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsHomeRecommendProduct;

import java.util.List;

public interface SmsHomeRecommendProductService {

    List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageNum, Integer pageSize);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    int updateSort(Long id, Integer sort);

    int create(List<SmsHomeRecommendProduct> smsHomeRecommendProduct);

    int delete(List<Long> ids);
}
