package com.macro.mall.tiny.dto;

import com.macro.mall.tiny.mbg.model.SmsCoupon;
import com.macro.mall.tiny.mbg.model.SmsCouponProductCategoryRelation;
import com.macro.mall.tiny.mbg.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/22 10:16
 */

public class SmsCouponParam extends SmsCoupon {


    @Setter
    @Getter
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;


    @Setter
    @Getter
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
