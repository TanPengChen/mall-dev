package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.OmsOrderDetail;
import com.macro.mall.tiny.mbg.model.OmsOrder;
import com.macro.mall.tiny.mbg.model.OmsOrderDeliveryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderQueryParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OmsOrderService {

    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageNum, Integer pageSize);

    OmsOrderDetail lisById(Long id);

    @Transactional
    int delivery(List<OmsOrderDeliveryParam> omsOrderDeliveryParam);

    /**
     * 修改订单备注
     * @param id
     * @param note
     * @param status
     * @return
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);

    /**
     * 批量删除订单
     * @param ids
     * @return
     */
    int delete(List<Long> ids);
}
