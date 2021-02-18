package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.PmsSkuStockMapper;
import com.macro.mall.tiny.mbg.model.PmsSkuStock;
import com.macro.mall.tiny.mbg.model.PmsSkuStockExample;
import com.macro.mall.tiny.dao.PmsSkuStockDao;
import com.macro.mall.tiny.service.PmsSkuStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/26 13:36
 */

@Service
public class PmsSkuStockServiceImpl implements PmsSkuStockService {

    @Autowired
    private PmsSkuStockMapper pmsSkuStockMapper;

    @Autowired
    private  PmsSkuStockDao pmsSkuStockDao ;

    @Override
    public List<PmsSkuStock> getList(Long pid, String keyword) {
        PmsSkuStockExample pmsSkuStockExample = new PmsSkuStockExample();
        PmsSkuStockExample.Criteria criteria = pmsSkuStockExample.createCriteria().andProductIdEqualTo(pid);
        if (!StringUtils.isEmpty(keyword)){
            criteria.andSkuCodeLike("%" + keyword + "%");
        }
        return pmsSkuStockMapper.selectByExample(pmsSkuStockExample);

    }

    @Override
    public int update(Long pid, List<PmsSkuStock> skuStockList) {
        return pmsSkuStockDao.replaceList(skuStockList);
    }
}
