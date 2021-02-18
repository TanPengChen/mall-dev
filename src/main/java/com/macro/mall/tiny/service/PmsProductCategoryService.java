package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.mbg.model.PmsProductCategory;
import com.macro.mall.tiny.mbg.model.PmsProductCategoryParam;

import java.util.List;

public interface PmsProductCategoryService {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();

    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    int create(PmsProductCategoryParam pmsProductCategory);

}
