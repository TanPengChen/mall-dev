package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.PmsProductAttribute;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductAttributeService {

    List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageNum, Integer pageSize);

    @Transactional
    int create(PmsProductAttributeParam pmsProductAttributeParam);

    int delete(List<Long> ids);
}
