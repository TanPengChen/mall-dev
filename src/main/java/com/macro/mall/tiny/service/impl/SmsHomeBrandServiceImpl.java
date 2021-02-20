package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.SmsHomeBrandMapper;
import com.macro.mall.tiny.mbg.model.SmsHomeBrand;
import com.macro.mall.tiny.mbg.model.SmsHomeBrandExample;
import com.macro.mall.tiny.service.SmsHomeBrandService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 14:00
 */

@Service
public class SmsHomeBrandServiceImpl implements SmsHomeBrandService {

    @Autowired
    private SmsHomeBrandMapper homeBrandMapper;

    @Override
    public List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        SmsHomeBrandExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(brandName)){
            criteria.andBrandNameLike("%" + brandName + "%");
        }
        if (recommendStatus != null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return homeBrandMapper.selectByExample(example);
    }

    @Override
    public int detele(List<Long> ids) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        return homeBrandMapper.deleteByExample(example);
    }

    @Override
    public int create(List<SmsHomeBrand> smsHomeBrand) {
        for (SmsHomeBrand homeBrand:smsHomeBrand) {
            homeBrand.setRecommendStatus(1);
            homeBrand.setSort(0);
            homeBrandMapper.insert(homeBrand);
        }
        return smsHomeBrand.size();
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeBrand smsHomeBrand = new SmsHomeBrand();
        smsHomeBrand.setSort(sort);
        smsHomeBrand.setId(id);
        return homeBrandMapper.updateByPrimaryKeySelective(smsHomeBrand);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeBrandExample example = new SmsHomeBrandExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeBrand smsHomeBrand = new SmsHomeBrand();
        smsHomeBrand.setRecommendStatus(recommendStatus);
        return homeBrandMapper.updateByExampleSelective(example,smsHomeBrand);
    }
}
