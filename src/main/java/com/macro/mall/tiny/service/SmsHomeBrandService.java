package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsHomeBrand;

import java.util.List;

public interface SmsHomeBrandService {

    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageNum, Integer pageSize);

    int detele(List<Long> ids);

    int create(List<SmsHomeBrand> smsHomeBrand);

    int updateSort(Long id, Integer sort);

    int updateRecommendStatus(List<Long> id, Integer recommendStatus);
}
