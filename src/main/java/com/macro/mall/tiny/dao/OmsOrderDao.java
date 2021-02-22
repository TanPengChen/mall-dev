package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.dto.OmsOrderDetail;
import com.macro.mall.tiny.mbg.model.OmsOrder;
import com.macro.mall.tiny.mbg.model.OmsOrderDeliveryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderDao {

    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    OmsOrderDetail getDetail(@Param("id") Long id);

    int delivery(@Param("list") List<OmsOrderDeliveryParam> omsOrderDeliveryParam);

}
