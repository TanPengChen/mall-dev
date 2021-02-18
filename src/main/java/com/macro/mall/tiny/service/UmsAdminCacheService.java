package com.macro.mall.tiny.service;



import java.util.List;

/**
 * 后台缓存操作类
 */
public interface UmsAdminCacheService {

    /**
     * 当角色相关资源改变时删除相关后台用户缓存
     * @param ids
     */
    void delResourceListByRoleIds(List<Long> ids);

    /**
     * 当角色相关资源信息改变时删除相关后台用户缓存
     * @param roleId
     */
    void delResourceListByRole(Long roleId);


    /**
     * 删除后台用户资源列表缓存
     * @param adminId
     */
    void delResourceList(Long adminId);

    /**
     * 删除后台用户缓存
     * @param id
     */
    void delAdmin(Long id);
}
