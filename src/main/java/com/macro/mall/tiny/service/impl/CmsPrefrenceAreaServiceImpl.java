package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.CmsPrefrenceAreaMapper;
import com.macro.mall.tiny.mbg.model.CmsPrefrenceArea;
import com.macro.mall.tiny.mbg.model.CmsPrefrenceAreaExample;
import com.macro.mall.tiny.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/23 16:43
 */

@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {

    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
