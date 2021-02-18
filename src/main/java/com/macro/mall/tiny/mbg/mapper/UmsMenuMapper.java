package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.UmsMenu;
import com.macro.mall.tiny.mbg.model.UmsMenuExample;

import java.util.List;

public interface UmsMenuMapper {

    List<UmsMenu> selectByExample(UmsMenuExample example);

    int updateByPrimaryKeySelective(UmsMenu record);

    int insert(UmsMenu umsMenu);

    int deleteByPrimaryKey(Long id);

    UmsMenu selectByPrimaryKey(Long id);
}
