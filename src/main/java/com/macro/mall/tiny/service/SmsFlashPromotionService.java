package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsFlashPromotion;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 16:14
 */

public interface SmsFlashPromotionService {

    List<SmsFlashPromotion> list(String title, Integer pageNum, Integer pageSize);

    int create(SmsFlashPromotion smsFlashPromotion);

    int delete(Long id);

    int update(Long id, SmsFlashPromotion smsFlashPromotion);

    int updateStatus(Long id, Integer status);
}
