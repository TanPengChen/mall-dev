package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.macro.mall.tiny.mbg.mapper.PmsProductAttributeMapper;
import com.macro.mall.tiny.mbg.model.PmsProductAttribute;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeExample;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeParam;
import com.macro.mall.tiny.service.PmsProductAttributeService;
import com.macro.mall.tiny.service.PmsProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/22 13:54
 */
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

    @Autowired
    private PmsProductAttributeMapper pmsProductAttributeMapper;

    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Override
    public List<PmsProductAttribute> getList(Long cid, Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.setOrderByClause("sort desc ");
        example.createCriteria().andProductAttributeCategoryIdEqualTo(cid).andTypeEqualTo(type);
        return pmsProductAttributeMapper.selectByExample(example);
    }

    @Override
    public int create(PmsProductAttributeParam pmsProductAttributeParam) {
        PmsProductAttribute pmsProductAttribute = new PmsProductAttribute();
        BeanUtils.copyProperties(pmsProductAttributeParam,pmsProductAttribute);
          int count = pmsProductAttributeMapper.insertSelective(pmsProductAttribute);
        //新增商品属性以后需要更新商品属性分类数量
        PmsProductAttributeCategory pmsProductAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getId());
       if (pmsProductAttributeCategory.getAttributeCount() != null) {
           if (pmsProductAttribute.getType() == 0) {
               pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount() + 1);
           } else if (pmsProductAttribute.getType() == 1) {
               pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount() + 1);
           }
       }
        productAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        //获取分类
        PmsProductAttribute pmsProductAttribute = pmsProductAttributeMapper.selectByPrimaryKey(ids.get(0));
        Integer type = pmsProductAttribute.getType();
        PmsProductAttributeCategory pmsProductAttributeCategory = productAttributeCategoryMapper.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
        PmsProductAttributeExample example = new PmsProductAttributeExample();
        example.createCriteria().andIdIn(ids);
        int count = pmsProductAttributeMapper.deleteByExample(example);
        //删除完成后修改数量
        if (type == 0){
            if (pmsProductAttributeCategory.getAttributeCount() >= count){
                pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount() - count);
            }else {
                pmsProductAttributeCategory.setAttributeCount(0);
            }
        }
        if (type == 1){
            if (pmsProductAttributeCategory.getParamCount() >= count){
                pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount() - count);
            }else {
                pmsProductAttributeCategory.setParamCount(0);
            }
        }
        productAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
        return 0;
    }
}
