package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dto.PmsProductQueryParam;
import com.macro.mall.tiny.mbg.mapper.PmsProductMapper;
import com.macro.mall.tiny.mbg.model.PmsProduct;
import com.macro.mall.tiny.mbg.model.PmsProductExample;
import com.macro.mall.tiny.service.PmsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/17 10:10
 */
@Service
public class PmsProductServiceImpl implements PmsProductService {

    private static Logger logger = LoggerFactory.getLogger(PmsProductServiceImpl.class);

    @Autowired
    private PmsProductMapper pmsProductMapper;

    @Override
    public List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductExample example = new PmsProductExample();
        PmsProductExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteStatusEqualTo(0);
        if (pmsProductQueryParam.getPublishStatus() != null){
            criteria.andPublishStatusEqualTo(pmsProductQueryParam.getPublishStatus());
        }
        if (pmsProductQueryParam.getVerifyStatus() != null){
            criteria.andVerifyStatusEqualTo(pmsProductQueryParam.getVerifyStatus());
        }
        if (!StringUtils.isEmpty(pmsProductQueryParam.getKeyword())){
           criteria.andNameLike("%" + pmsProductQueryParam.getKeyword() + "%");
        }
        if (!StringUtils.isEmpty(pmsProductQueryParam.getProductSn())){
           criteria.andProductSnEqualTo(pmsProductQueryParam.getProductSn());
        }
        if (pmsProductQueryParam.getBrandId() != null){
            criteria.andBrandIdEqualTo(pmsProductQueryParam.getBrandId());
        }
          if (pmsProductQueryParam.getProductCategoryId() != null){
            criteria.andProductCategoryIdEqualTo(pmsProductQueryParam.getProductCategoryId());
        }
        return pmsProductMapper.selectByExample(example);
    }

    @Override
    public int newStatus(List<Long> ids, Integer newStatus) {
        PmsProduct record = new PmsProduct();
        record.setNewStatus(newStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return pmsProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int publishStatus(List<Long> ids, Integer publishStatus) {
        PmsProduct record = new PmsProduct();
        record.setPublishStatus(publishStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return pmsProductMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int recommendStatus(List<Long> ids, Integer recommendStatus) {
        PmsProduct record = new PmsProduct();
        record.setRecommandStatus(recommendStatus);
        PmsProductExample example = new PmsProductExample();
        example.createCriteria().andIdIn(ids);
        return pmsProductMapper.updateByExampleSelective(record,example);
    }
}
