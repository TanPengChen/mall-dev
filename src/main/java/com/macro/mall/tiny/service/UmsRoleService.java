package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsMenu;
import com.macro.mall.tiny.mbg.model.UmsResource;
import com.macro.mall.tiny.mbg.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台角色管理
 */
public interface UmsRoleService {

    /**
     * 添加角色
     */
    int create(UmsRole umsRole);

    /**
     * 修改角色信息
     */
    int update(Long id,UmsRole role);

    /**
     * 批量删除角色
     */
    int delete(List<Long> ids);

    /**
     * 获取所有角色列表
     */
    List<UmsRole> list();

    /**
     * 分页获取角色列表
     */
    List<UmsRole> list(String keyword,Integer pageNum,Integer pageSize);

    /**
     * 根据管理ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 获取角色相关菜单
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 获取角色相关资源
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * 给角色分配菜单
     */
    @Transactional
     int allocMenu(Long roleId,List<Long> menuIds);

    /**
     * 给角色分配资源
     */
    @Transactional
    int allocResource(Long roleId,List<Long> resourceIds);

    int updateStatus(Long id, Integer status);
}
