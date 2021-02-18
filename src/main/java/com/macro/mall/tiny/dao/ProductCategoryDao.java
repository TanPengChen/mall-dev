package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/17 10:52
 */

public interface ProductCategoryDao {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();

}
