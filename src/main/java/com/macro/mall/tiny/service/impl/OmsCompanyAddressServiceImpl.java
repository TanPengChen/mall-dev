package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.OmsCompanyAddressMapper;
import com.macro.mall.tiny.mbg.model.OmsCompanyAddress;
import com.macro.mall.tiny.mbg.model.OmsCompanyAddressExample;
import com.macro.mall.tiny.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/22 16:47
 */

@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {

    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;


    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
