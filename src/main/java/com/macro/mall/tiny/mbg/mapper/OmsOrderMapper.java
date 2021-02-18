package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.mbg.model.OmsOrderDetail;
import com.macro.mall.tiny.mbg.model.OmsOrderExample;

public interface OmsOrderMapper {

    CommonPage<OmsOrderDetail> selectByExample(OmsOrderExample example);
}
