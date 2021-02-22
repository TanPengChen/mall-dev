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
    public int create(SmsFlashPromotion smsFlashPromotion) throws Exception {
        try {
            StringUtils.isBlank(smsFlashPromotion.getTitle());
        }catch (Exception e){
            e.printStackTrace();
        }
        if (smsFlashPromotion.getStartDate() == null){
            throw new Exception("请设置开始时间");
        }
        if (smsFlashPromotion.getEndDate() == null){
            throw new Exception("请设置结束时间");
        }
        if (smsFlashPromotion.getStartDate().compareTo(smsFlashPromotion.getEndDate() )> 0){
            throw new Exception("开始结束时间不对，请重新设置");
        }
        return smsFlashPromotionMapper.insertSelective(smsFlashPromotion);
    }

    @Override
    public int delete(Long id) {
        return smsFlashPromotionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, SmsFlashPromotion smsFlashPromotion) throws Exception {
        smsFlashPromotion.setId(id);
        if (smsFlashPromotion.getStartDate().compareTo(smsFlashPromotion.getEndDate()) > 0){
            throw new Exception("开始结束时间不对，请重新设置");
        }
        if (StringUtils.isBlank(smsFlashPromotion.getTitle())){
            throw new Exception("活动标题不能为空");
        }
        return smsFlashPromotionMapper.updateByPrimaryKeySelective(smsFlashPromotion);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsFlashPromotion smsFlashPromotion = new SmsFlashPromotion();
        smsFlashPromotion.setId(id);
        smsFlashPromotion.setStatus(status);
        return smsFlashPromotionMapper.updateByPrimaryKeySelective(smsFlashPromotion);
    }

}
