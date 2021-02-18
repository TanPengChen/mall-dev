package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含有分类下属性的dto
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/29 17:00
 */

public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {

    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttribute> productAttributeList;

}
