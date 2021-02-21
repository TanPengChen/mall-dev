package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsHomeAdvertise;

import java.util.List;

public interface SmsHomeAdvertiseService {

    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageNum, Integer pageSize);

    int create(SmsHomeAdvertise homeAdvertise) throws Exception;

    int delete(Long ids);

    int update(Long id, SmsHomeAdvertise advertise);

    List<SmsHomeAdvertise> getItem(Long id);

    int updateStatus(Long id, Integer status);
}
