package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsResourceCategory;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/15 12:47
 */

public interface UmsResourceCategoryService {

    /**
     * 查询所有后台资源
     * @return
     */
    List<UmsResourceCategory> listAll();

    /**
     * 添加分类
     * @param umsResourceCategory
     * @return
     */
    int create(UmsResourceCategory umsResourceCategory) throws Exception;

    /**
     * 根据id删除资源
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据ID更新资源信息
     * @param id
     * @param umsResourceCategory
     * @return
     */
    int update(Long id, UmsResourceCategory umsResourceCategory) throws Exception;
}
