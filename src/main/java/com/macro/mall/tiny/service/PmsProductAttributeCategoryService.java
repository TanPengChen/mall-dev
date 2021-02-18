package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategoryItem;

import java.util.List;

public interface PmsProductAttributeCategoryService {

    List<PmsProductAttributeCategory> getList(Integer pageNum, Integer pageSize);

    List<PmsProductAttributeCategoryItem> getListWithAttr();

    int create(String name);

    int delete(Long id);
}
