package com.macro.mall.tiny.dto;

import com.macro.mall.tiny.mbg.model.OmsCompanyAddress;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/29 15:33
 */

public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {

    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}
