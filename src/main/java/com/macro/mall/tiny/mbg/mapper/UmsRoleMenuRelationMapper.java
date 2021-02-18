package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsRoleMenuRelation;
import com.macro.mall.tiny.mbg.model.UmsRoleMenuRelationExample;

public interface UmsRoleMenuRelationMapper {

    int deleteByExample(UmsRoleMenuRelationExample example);

    int insert(UmsRoleMenuRelation record);
}
