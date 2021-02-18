package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsResource;
import com.macro.mall.tiny.mbg.model.UmsResourceExample;

import java.util.List;

public interface UmsResourceMapper {

    List<UmsResource> selectByExample(UmsResourceExample example);

    int insert(UmsResource umsResource);

    int updateByPrimaryKeySelective(UmsResource umsResource);

    int deleteByPrimaryKey(Long id);
}
