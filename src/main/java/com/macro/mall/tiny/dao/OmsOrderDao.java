package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.mbg.model.OmsOrder;
import com.macro.mall.tiny.mbg.model.OmsOrderQueryParam;

import java.util.List;

public interface OmsOrderDao {

    List<OmsOrder> getList(OmsOrderQueryParam queryParam);
}
