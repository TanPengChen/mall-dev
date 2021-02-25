package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.UmsMemberLevelMapper;
import com.macro.mall.tiny.mbg.model.UmsMemberLevel;
import com.macro.mall.tiny.mbg.model.UmsMemberLevelExample;
import com.macro.mall.tiny.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/24 10:39
 */

@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {

    @Autowired
    private UmsMemberLevelMapper umsMemberLevelMapper;

    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return umsMemberLevelMapper.selectByExample(example);
    }
}
