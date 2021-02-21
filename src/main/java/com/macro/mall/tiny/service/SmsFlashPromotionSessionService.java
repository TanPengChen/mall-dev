package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsFlashPromotionSessionDetail;

import java.util.List;

public interface SmsFlashPromotionSessionService {

    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
