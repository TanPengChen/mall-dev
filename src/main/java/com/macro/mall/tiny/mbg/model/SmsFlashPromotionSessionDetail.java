package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 包含商品数量的场次信息
 * create by tanpeng 2021-02-21
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSession {

    @ApiModelProperty("商品数量")
    private Long productCount;

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }
}
