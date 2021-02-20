package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.SmsCouponMapper;
import com.macro.mall.tiny.mbg.model.SmsCoupon;
import com.macro.mall.tiny.mbg.model.SmsCouponExample;
import com.macro.mall.tiny.service.SmsCouponService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 15:10
 */
@Service
public class SmsCouponServiceImpl implements SmsCouponService {

    @Autowired
    private SmsCouponMapper couponMapper;

    @Override
    public List<SmsCoupon> list(String name, Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SmsCouponExample example = new SmsCouponExample();
        SmsCouponExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)){
             criteria.andNameLike("%" + name + "%");
        }
        if (type != null){
            criteria.andTypeEqualTo(type);
        }
        return couponMapper.selectByExample(example);
    }

    @Override
    public int delete(Long id) {
        return couponMapper.deleteByPrimaryKey(id);
    }
}
