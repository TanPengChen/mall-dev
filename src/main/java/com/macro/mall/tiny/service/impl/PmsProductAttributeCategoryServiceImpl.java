package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategoryExample;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategoryItem;
import com.macro.mall.tiny.service.PmsProductAttributeCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/22 10:56
 */
@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService{

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductAttributeCategoryServiceImpl.class);

    @Autowired
    private PmsProductAttributeCategoryMapper productAttributeCategoryMapper;

    @Override
    public List<PmsProductAttributeCategory> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return productAttributeCategoryMapper.selectByExample(new PmsProductAttributeCategoryExample());
    }

    @Override
    public List<PmsProductAttributeCategoryItem> getListWithAttr() {
        return null;
    }

    @Override
    public int create(String name) {
        PmsProductAttributeCategory pmsProductAttributeCategory = new PmsProductAttributeCategory();
        pmsProductAttributeCategory.setName(name);
        return productAttributeCategoryMapper.insertSelective(pmsProductAttributeCategory);
    }

    @Override
    public int delete(Long id) {
        return productAttributeCategoryMapper.deleteByPrimaryKey(id);
    }
}
