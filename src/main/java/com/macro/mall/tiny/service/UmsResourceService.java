package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsResource;

import java.util.List;

public interface UmsResourceService {


    /**
     * 分页查询资源
     * @param categoryId
     * @param nameKeyword
     * @param urlKeyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageNum, Integer pageSize);

    /**
     * 添加后台资源管理
     * @param umsResource
     * @return
     */
    int create(UmsResource umsResource);

    /**
     * 修改后台资源
     * @param id
     * @param umsResource
     * @return
     */
    int update(Long id, UmsResource umsResource);

    /**
     * 根据ID删除后台资源
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 查询所有后台资源
     * @return
     */
    List<UmsResource> listAll();

}
