package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.OmsOrder;
import com.macro.mall.tiny.mbg.model.OmsOrderQueryParam;

import java.util.List;

public interface OmsOrderService {

    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageNum, Integer pageSize);
}
