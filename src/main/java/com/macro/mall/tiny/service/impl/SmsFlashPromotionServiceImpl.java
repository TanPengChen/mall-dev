package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.SmsFlashPromotionMapper;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotion;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionExample;
import com.macro.mall.tiny.service.SmsFlashPromotionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 16:14
 */

@Service
public class SmsFlashPromotionServiceImpl implements SmsFlashPromotionService {

    @Autowired
    private SmsFlashPromotionMapper smsFlashPromotionMapper;

    @Override
    public List<SmsFlashPromotion> list(String title, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SmsFlashPromotionExample example = new SmsFlashPromotionExample();
        SmsFlashPromotionExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(title)){
            criteria.andTitleLike("%" + title + "%");
        }
        return smsFlashPromotionMapper.selectByExample(example);
    }

    @Override
    public int create(SmsFlashPromotion smsFlashPromotion) {
        return smsFlashPromotionMapper.insertSelective(smsFlashPromotion);
    }

    @Override
    public int delete(Long id) {
        return smsFlashPromotionMapper.deleteByPrimaryKey(id);
    }
}
