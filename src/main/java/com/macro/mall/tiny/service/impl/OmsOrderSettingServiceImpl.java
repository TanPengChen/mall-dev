package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.OmsOrderSettingMapper;
import com.macro.mall.tiny.mbg.model.OmsOrderSetting;
import com.macro.mall.tiny.service.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/29 13:33
 */
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {

    @Autowired
    private OmsOrderSettingMapper omsOrderSettingMapper;

    @Override
    public OmsOrderSetting orderSetting(Long id) {
        return  omsOrderSettingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, OmsOrderSetting omsOrderSetting) {
        omsOrderSetting.setId(id);
        return omsOrderSettingMapper.updateByPrimaryKey(omsOrderSetting);
    }
}
