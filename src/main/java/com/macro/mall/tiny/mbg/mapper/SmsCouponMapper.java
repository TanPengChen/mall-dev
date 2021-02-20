package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsCoupon;
import com.macro.mall.tiny.mbg.model.SmsCouponExample;

import java.util.List;

public interface SmsCouponMapper {

    List<SmsCoupon> selectByExample(SmsCouponExample example);

    int deleteByPrimaryKey(Long id);

}
