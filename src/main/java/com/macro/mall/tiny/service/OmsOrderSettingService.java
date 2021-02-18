package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.OmsOrderSetting;

public interface OmsOrderSettingService {

    OmsOrderSetting orderSetting(Long id);

    int update(Long id, OmsOrderSetting omsOrderSetting);

}
