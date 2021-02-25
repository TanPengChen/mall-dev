package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsMemberLevel;

import java.util.List;

public interface UmsMemberLevelService {

    List<UmsMemberLevel> list(Integer defaultStatus);
}
