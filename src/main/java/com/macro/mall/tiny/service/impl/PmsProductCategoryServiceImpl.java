package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dao.PmsProductCategoryDao;
import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.mbg.mapper.PmsProductCategoryMapper;
import com.macro.mall.tiny.mbg.model.PmsProductCategory;
import com.macro.mall.tiny.mbg.model.PmsProductCategoryExample;
import com.macro.mall.tiny.mbg.model.PmsProductCategoryParam;
import com.macro.mall.tiny.service.PmsProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/17 10:44
 */
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService{

    @Autowired
    private PmsProductCategoryDao pmsProductCategoryDao;

    @Autowired
    private PmsProductCategoryMapper pmsProductCategoryMapper;

    @Override
    public List<PmsProductCategoryWithChildrenItem> listWithChildren() {
        return pmsProductCategoryDao.listWithChildren();
    }

    @Override
    public List<PmsProductCategory> getList(Long parentId,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageSize,pageNum);
        PmsProductCategoryExample example = new PmsProductCategoryExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return pmsProductCategoryMapper.selectByExample(example);
    }

    @Override
    public int create(PmsProductCategoryParam pmsProductCategoryParam) {
        PmsProductCategory pmsProductCategory = new PmsProductCategory();
        pmsProductCategory.setProductCount(0);
        BeanUtils.copyProperties(pmsProductCategoryParam,pmsProductCategory);
        //没有父分类时为一级分类
        setCategoryLevel(pmsProductCategory);
        int count = pmsProductCategoryMapper.insertSelective(pmsProductCategory);
        //创建筛选属性关联
        List<Long> productAttributeIdList = pmsProductCategoryParam.getProductAttributeIdList();
        if (!CollectionUtils.isEmpty(productAttributeIdList)){
            insertRelationList(pmsProductCategory.getId(),productAttributeIdList);
        }
        return count;
    }

    /**
     * 批量插入商品分类与筛选属性关系表
     * @param id
     * @param productAttributeIdList
     */
    private void insertRelationList(Long id, List<Long> productAttributeIdList) {

    }

    /**
     * 根据分类的parentId设置分类的level
     * @param pmsProductCategory
     */
    private void setCategoryLevel(PmsProductCategory pmsProductCategory) {
        //没有父分类时设置为一级分类
        if (pmsProductCategory.getParentId() == 0){
            pmsProductCategory.setLevel(0);
        }else {
            //有父分类时选择根据父分类level设置
            PmsProductCategory pmsProductCategory1 = pmsProductCategoryMapper.selectByPrimaryKey(pmsProductCategory.getId());
            if (pmsProductCategory != null){
                pmsProductCategory1.setLevel(pmsProductCategory1.getLevel() + 1);
            }else {
                pmsProductCategory1.setLevel(0);
            }
        }

    }
}
