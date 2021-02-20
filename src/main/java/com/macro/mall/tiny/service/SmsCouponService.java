package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsCoupon;

import java.util.List;

public interface SmsCouponService {

    List<SmsCoupon> list(String name, Integer type, Integer pageNum, Integer pageSize);

    int delete(Long id);
}
