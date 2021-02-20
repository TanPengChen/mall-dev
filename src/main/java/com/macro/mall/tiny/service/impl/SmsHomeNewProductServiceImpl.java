package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.SmsHomeNewProductMapper;
import com.macro.mall.tiny.mbg.model.SmsHomeNewProduct;
import com.macro.mall.tiny.mbg.model.SmsHomeNewProductExample;
import com.macro.mall.tiny.service.SmsHomeNewProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 11:10
 */
@Service
public class SmsHomeNewProductServiceImpl implements SmsHomeNewProductService {

    @Autowired
    private SmsHomeNewProductMapper smsHomeNewProductMapper;

    @Override
    public List<SmsHomeNewProduct> list(String productName, Integer recommendStatus, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        SmsHomeNewProductExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(productName)){
            criteria.andProductNameLike("%" + productName + "%");
        }
        if (recommendStatus != null){
            criteria.andRecommendStatusEqualTo(recommendStatus);
        }
        return smsHomeNewProductMapper.selectByExample(example);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        SmsHomeNewProduct homeNewProduct = new SmsHomeNewProduct();
        homeNewProduct.setRecommendStatus(recommendStatus);
        return smsHomeNewProductMapper.updateByExampleSelective(example,homeNewProduct);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        SmsHomeNewProduct smsHomeNewProduct = new SmsHomeNewProduct();
        smsHomeNewProduct.setId(id);
        smsHomeNewProduct.setSort(sort);
        return smsHomeNewProductMapper.updateByPrimaryKeySelective(smsHomeNewProduct);
    }

    @Override
    public int create(List<SmsHomeNewProduct> smsHomeNewProduct) {
        for (SmsHomeNewProduct homeNewProduct:smsHomeNewProduct) {
            homeNewProduct.setRecommendStatus(1);
            homeNewProduct.setSort(0);
            smsHomeNewProductMapper.insert(homeNewProduct);
        }
        return smsHomeNewProduct.size();
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeNewProductExample example = new SmsHomeNewProductExample();
        example.createCriteria().andIdIn(ids);
        return smsHomeNewProductMapper.deleteByExample(example);
    }
}
