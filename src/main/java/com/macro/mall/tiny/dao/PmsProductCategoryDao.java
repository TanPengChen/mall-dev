package com.macro.mall.tiny.dao;


import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义DAO
 */
public interface PmsProductCategoryDao {

    /**
     * 获取商品分类及其子类
     * @return
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();





}
