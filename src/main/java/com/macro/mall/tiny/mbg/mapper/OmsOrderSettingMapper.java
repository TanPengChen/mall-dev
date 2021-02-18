package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.OmsOrderSetting;


public interface OmsOrderSettingMapper {

   OmsOrderSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKey(OmsOrderSetting omsOrderSetting);
}
