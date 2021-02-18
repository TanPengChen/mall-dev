package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsMenu;
import com.macro.mall.tiny.mbg.model.UmsMenuNode;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/15 19:48
 */

public interface UmsMenuService {

    /**
     * 分页查询菜单列表
     * @param parentId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsMenu> list(Long parentId, Integer pageNum, Integer pageSize);

    /**
     * 菜单列表隐藏
     * @param id
     * @param hidden
     * @return
     */
    int updateHidden(Long id, Integer hidden);

    /**
     * 添加后台菜单
     * @param umsMenu
     * @return
     */
    int create(UmsMenu umsMenu);

    /**
     * 根据ID删除后台管理
     * @param id
     * @return
     */
    int delete(Long id);


    /**
     * 根据ID获取菜单详情
     * @param id
     * @return
     */
    UmsMenu getItem(Long id);

    /**
     * 修改后台菜单
     * @param id
     * @param umsMenu
     * @return
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * 返回树形结构子菜单
     * @return
     */
    List<UmsMenuNode> treeList();

}
