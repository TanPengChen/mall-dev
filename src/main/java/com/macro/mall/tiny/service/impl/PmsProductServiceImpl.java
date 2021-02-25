package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dao.*;
import com.macro.mall.tiny.dto.PmsProductParam;
import com.macro.mall.tiny.dto.PmsProductQueryParam;
import com.macro.mall.tiny.mbg.mapper.PmsProductMapper;
import com.macro.mall.tiny.mbg.model.PmsProduct;
import com.macro.mall.tiny.mbg.model.PmsProductExample;
import com.macro.mall.tiny.mbg.model.PmsSkuStock;
import com.macro.mall.tiny.service.PmsProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.macro.mall.tiny.service.impl.EsProductServiceImpl.LOGGER;

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
    @Autowired
    private PmsMemberPriceDao memberPriceDao;
    @Autowired
    private PmsProductLadderDao productLadderDao;
    @Autowired
    private PmsProductFullReductionDao productFullReductionDao;
    @Autowired
    private PmsSkuStockDao skuStockDao;
    @Autowired
    private PmsProductAttributeValueDao productAttributeValueDao;
    @Autowired
    private CmsSubjectProductRelationDao subjectProductRelationDao;
    @Autowired
    private CmsPrefrenceAreaProductRelationDao prefrenceAreaProductRelationDao;


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

    @Override
    public int create(PmsProductParam pmsProductParam) {
        int count;
        //创建商品
        PmsProduct pmsProduct = pmsProductParam;
        pmsProduct.setId(null);
        pmsProductMapper.insertSelective (pmsProduct);
        //根据促销类型设价格：会员价格、阶梯价格、满减价格
        Long productId =pmsProduct.getId();
        //会员价格
        relateAndInsertList(memberPriceDao,pmsProductParam.getMemberPriceList(),productId);
        //阶梯价格
        relateAndInsertList(productLadderDao,pmsProductParam.getProductLadderList(),productId);
        //满减价格
        relateAndInsertList(productFullReductionDao,pmsProductParam.getProductFullReductionList(),productId);
        //处理sku的编码
        handleSkuStockCode(pmsProductParam.getSkuStockList(),productId);
        //添加sku库存信息
        relateAndInsertList(skuStockDao,pmsProductParam.getSkuStockList(),productId);
        //添加商品参数，添加自定义商品规格
        relateAndInsertList(productAttributeValueDao,pmsProductParam.getProductAttributeValueList(),productId);
        //关联专题
        relateAndInsertList(subjectProductRelationDao,pmsProductParam.getSubjectProductRelationList(),productId);
        //关联优选
        relateAndInsertList(prefrenceAreaProductRelationDao,pmsProductParam.getPrefrenceAreaProductRelationList(),productId);
        count=1;
        return count;
    }


    private void handleSkuStockCode(List<PmsSkuStock> skuStockList, Long productId) {
        if (CollectionUtils.isEmpty(skuStockList))return;
        for (int i = 0;i<skuStockList.size();i++){
            PmsSkuStock pmsSkuStock = skuStockList.get(i);
            if (StringUtils.isEmpty(pmsSkuStock.getSkuCode())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                StringBuilder sb = new StringBuilder();
                //日期
                sb.append(sdf.format(new Date()));
                //四位商品id
                sb.append(String.format("%04d",productId));
                //三位索引
                sb.append(String.format("%03d",productId));
                pmsSkuStock.setSkuCode(sb.toString());

            }
        }

    }


    /**
     * 建立和插入关系表操作
     * @param dao 可以操作的dao
     * @param dataList 要插入的数据
     * @param productId 建立的关系id
     */
    private void relateAndInsertList(Object dao, List dataList, Long productId) {
        try {
            if (CollectionUtils.isEmpty(dataList)) return;
            for (Object item:dataList) {
              Method setId = item.getClass().getMethod("setId",Long.class);
              setId.invoke(item,(Long)null);
              Method setProductId = item.getClass().getMethod("setProductId",Long.class);
              setProductId.invoke(item,productId);
            }
            Method insertList = dao.getClass().getMethod("insertList",List.class);
            insertList.invoke(dao,dataList);

        }catch (Exception e){
            LOGGER.warn("创建产品出错:{}",e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }
}
