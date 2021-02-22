package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/22 14:51
 */
@Getter
@Setter
public class OmsOrderDeliveryParam {

    @ApiModelProperty("订单Id")
    private Long orderId;

    @ApiModelProperty("物流公司")
    private String deliveryCompany;

    @ApiModelProperty("订单编号")
    private String deliverySn;
}
