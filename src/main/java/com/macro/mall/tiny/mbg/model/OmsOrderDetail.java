package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/25 15:54
 */

public class OmsOrderDetail extends OmsOrder {


    @Setter
    @Getter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem>  orderItemList;

    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
