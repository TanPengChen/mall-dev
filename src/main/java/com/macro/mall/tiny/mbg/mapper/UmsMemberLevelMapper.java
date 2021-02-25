package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsMemberLevel;
import com.macro.mall.tiny.mbg.model.UmsMemberLevelExample;

import java.util.List;

public interface UmsMemberLevelMapper {

    List<UmsMemberLevel> selectByExample(UmsMemberLevelExample example);
}
