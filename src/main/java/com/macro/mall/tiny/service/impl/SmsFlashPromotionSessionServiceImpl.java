package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.SmsFlashPromotionSessionMapper;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionSession;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionSessionDetail;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionSessionExample;
import com.macro.mall.tiny.service.SmsFlashPromotionProductRelationService;
import com.macro.mall.tiny.service.SmsFlashPromotionSessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SmsFlashPromotionSessionServiceImpl implements SmsFlashPromotionSessionService {

    @Autowired
    private SmsFlashPromotionSessionMapper smsFlashPromotionSessionMapper;

    @Autowired
    private SmsFlashPromotionProductRelationService relationService;

    @Override
    public List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        List<SmsFlashPromotionSessionDetail> result = new ArrayList<>();
        SmsFlashPromotionSessionExample example = new SmsFlashPromotionSessionExample();
        example.createCriteria().andStatusEqualTo(1);
        List<SmsFlashPromotionSession> flashPromotionSessionList = smsFlashPromotionSessionMapper.selectByExample(example);
        for (SmsFlashPromotionSession list:flashPromotionSessionList) {
            SmsFlashPromotionSessionDetail sessionDetail = new SmsFlashPromotionSessionDetail();
            BeanUtils.copyProperties(flashPromotionSessionList,sessionDetail);
           long count =  relationService.getCount(flashPromotionId,list.getId());
           sessionDetail.setProductCount(count);
            result.add(sessionDetail);
        }
        return result;
    }
}
