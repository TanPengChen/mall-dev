package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.dto.QueryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnApply;

import java.util.List;

public interface OmsOrderReturnApplyDao {

    List<OmsOrderReturnApply> getList(QueryParam queryParam);
}
