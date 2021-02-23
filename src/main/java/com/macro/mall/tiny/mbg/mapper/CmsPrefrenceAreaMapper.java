package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.CmsPrefrenceArea;
import com.macro.mall.tiny.mbg.model.CmsPrefrenceAreaExample;

import java.util.List;

public interface CmsPrefrenceAreaMapper {

    List<CmsPrefrenceArea> selectByExample(CmsPrefrenceAreaExample cmsPrefrenceAreaExample);
}
