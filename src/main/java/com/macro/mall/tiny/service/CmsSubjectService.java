package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.CmsSubject;

import java.util.List;

public interface CmsSubjectService {

    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);

    List<CmsSubject> listAll();

}
