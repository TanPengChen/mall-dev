package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.mbg.model.OmsOrder;
import com.macro.mall.tiny.mbg.model.OmsOrderDetail;
import com.macro.mall.tiny.mbg.model.OmsOrderExample;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderMapper {

    CommonPage<OmsOrderDetail> selectByExample(OmsOrderExample example);

    int updateByPrimaryKeySelective(OmsOrder omsOrder);

    int updateByExampleSelective(@Param("record") OmsOrder omsOrder, @Param("example") OmsOrderExample example);
}
