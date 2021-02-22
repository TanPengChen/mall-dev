package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.dto.OmsUpdateStatusParam;
import com.macro.mall.tiny.dto.QueryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnApply;

import java.util.List;

public interface OmsOrderReturnApplyService {

    List<OmsOrderReturnApply> list(QueryParam queryParam, Integer pageNum, Integer pageSize);

    OmsOrderReturnApplyResult listById(Long id);

    int updateStatus(Long id, OmsUpdateStatusParam statusParam);
}
