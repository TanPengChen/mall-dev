package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsFlashPromotion;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionExample;

import java.util.List;

public interface SmsFlashPromotionMapper {

    List<SmsFlashPromotion> selectByExample(SmsFlashPromotionExample example);

    int insertSelective(SmsFlashPromotion smsFlashPromotion);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsFlashPromotion smsFlashPromotion);
}
