package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsHomeAdvertise;

import java.util.List;

public interface SmsHomeAdvertiseService {

    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageNum, Integer pageSize);

    int create(SmsHomeAdvertise homeAdvertise);

    int delete(Long ids);
}
