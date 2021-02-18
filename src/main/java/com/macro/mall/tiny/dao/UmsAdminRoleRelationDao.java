package com.macro.mall.tiny.dao;


import com.macro.mall.tiny.mbg.model.UmsAdminRoleRelation;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.mbg.model.UmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * Created by macro on 2018/10/8.
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);

    /**
     * 获取用户所有角色
     * @param adminId
     * @return
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 批量插入用户角色关系
     * @param adminRoleRelationList
     * @return
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);
}
