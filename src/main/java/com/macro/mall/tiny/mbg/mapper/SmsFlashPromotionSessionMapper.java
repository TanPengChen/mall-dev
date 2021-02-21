package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsFlashPromotionSession;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionSessionExample;

import java.util.List;

public interface SmsFlashPromotionSessionMapper {

    List<SmsFlashPromotionSession> selectByExample(SmsFlashPromotionSessionExample example);
}
