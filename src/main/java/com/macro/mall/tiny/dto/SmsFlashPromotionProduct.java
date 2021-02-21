package com.macro.mall.tiny.dto;


import com.macro.mall.tiny.mbg.model.PmsProduct;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.lucene.util.SmallFloat;

/**
 * 限时购及产品封装信息
 * create by tanpeng on 2021-02-21
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {



    @Setter
    @Getter
    @ApiModelProperty(value = "关联产品")
    private PmsProduct pmsProduct;
}
