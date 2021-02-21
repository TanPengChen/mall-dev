package com.macro.mall.tiny.service.impl;


/**
 * 现时购商品管理Service
 * create by tanpeng 2021-02-21
 */
public interface SmsFlashPromotionProductRelationService {


    /**
     * 根据活动和场次id获取商品关系数量
     * @param flashPromotionId        限时购id
     * @param flashPromotionSessionId 限时购场次id
     */
    long getCount(Long flashPromotionId,Long flashPromotionSessionId);
}
