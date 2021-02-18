package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsHomeAdvertise;
import com.macro.mall.tiny.mbg.model.SmsHomeAdvertiseExample;

import java.util.List;

public interface SmsHomeAdvertiseMapper {

    List<SmsHomeAdvertise> selectByExample(SmsHomeAdvertiseExample example);

    int insert(SmsHomeAdvertise homeAdvertise);

    int deleteByPrimaryKey(Long id);
}
