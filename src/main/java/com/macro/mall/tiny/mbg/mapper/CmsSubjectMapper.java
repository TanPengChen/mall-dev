package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.CmsSubject;
import com.macro.mall.tiny.mbg.model.CmsSubjectExample;

import java.util.List;

public interface CmsSubjectMapper {

    List<CmsSubject> selectByExample(CmsSubjectExample example);
}
