package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.OmsOrderReturnReason;

import java.util.List;

public interface OmsOrderReturnReasonService {

    List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize);

    int create(OmsOrderReturnReason omsOrderReturnReason) throws Exception;

    int delete(List<Long> ids);

    OmsOrderReturnReason listById(Long id);

    int update(OmsOrderReturnReason omsOrderReturnReason, Long id);

    int updateStatus(Integer status, List<Long> ids);
}
