package com.macro.mall.tiny.service;

import com.macro.mall.tiny.dto.QueryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnApply;

import java.util.List;

public interface OmsOrderReturnApplyService {

    List<OmsOrderReturnApply> list(QueryParam queryParam, Integer pageNum, Integer pageSize);
}
