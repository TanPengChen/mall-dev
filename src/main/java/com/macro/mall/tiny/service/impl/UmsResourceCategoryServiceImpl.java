package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.UmsResourceCategoryMapper;
import com.macro.mall.tiny.mbg.model.UmsResourceCategory;
import com.macro.mall.tiny.mbg.model.UmsResourceCategoryExample;
import com.macro.mall.tiny.service.UmsResourceCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/15 12:47
 */

@Service
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsResourceCategoryServiceImpl.class);

    @Autowired
    private UmsResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<UmsResourceCategory> listAll() {
        UmsResourceCategoryExample example = new UmsResourceCategoryExample();
        example.setOrderByClause("sort desc");
        return resourceCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(UmsResourceCategory umsResourceCategory) throws Exception {
        umsResourceCategory.setCreateTime(new Date());
        if (StringUtils.isEmpty(umsResourceCategory.getName())){
            throw new Exception("模块名不能为空");
        }
        return resourceCategoryMapper.insert(umsResourceCategory);
    }

    @Override
    public int delete(Long id) {
        return resourceCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, UmsResourceCategory umsResourceCategory) throws Exception {
        umsResourceCategory.setId(id);
        if (StringUtils.isEmpty(umsResourceCategory.getName())) {
           throw new Exception("模块名称不能为空");
        }

        return resourceCategoryMapper.updateByPrimaryKeySelective(umsResourceCategory);
    }
}
