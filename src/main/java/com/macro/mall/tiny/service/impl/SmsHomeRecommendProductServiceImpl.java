package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.SmsHomeRecommendProductMapper;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendProduct;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendProductExample;
import com.macro.mall.tiny.service.SmsHomeRecommendProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 9:26
 */

@Service
public class SmsHomeRecommendProductServiceImpl implements SmsHomeRecommendProductService {


    @Autowired
    private SmsHomeRecommendProductMapper recommendProductMapper;

    @Override
    public List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        SmsHomeRecommendProductExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(productName)) {
            criteria.andProductNameLike("%" + productName + "%");
        }
        if (recommendStatus != null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        example.setOrderByClause("sort desc");
        return recommendProductMapper.selectByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeRecommendProduct recommendProduct = new SmsHomeRecommendProduct();
        recommendProduct.setRecommendStatus(recommendStatus);
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        return recommendProductMapper.updateByExampleSelective(example,recommendProduct);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeRecommendProduct recommendProduct = new SmsHomeRecommendProduct();
        recommendProduct.setSort(sort);
        recommendProduct.setId(id);
        return recommendProductMapper.updateByPrimaryKeySelective(recommendProduct);
    }

    @Override
    public int create(List<SmsHomeRecommendProduct> smsHomeRecommendProduct) {
        for (SmsHomeRecommendProduct homeRecommendProduct:smsHomeRecommendProduct) {
            homeRecommendProduct.setSort(0);
            homeRecommendProduct.setRecommendStatus(1);
            recommendProductMapper.insert(homeRecommendProduct);
        }
        return smsHomeRecommendProduct.size();
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeRecommendProductExample example = new SmsHomeRecommendProductExample();
        example.createCriteria().andIdIn(ids);
        return recommendProductMapper.deleteByExample(example);
    }
}
