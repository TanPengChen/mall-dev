package com.macro.mall.tiny.dto;

import com.macro.mall.tiny.mbg.model.PmsProductAttribute;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/29 17:12
 */

public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {

@Getter
@Setter
@ApiModelProperty(value = "商品属性列表")
private List<PmsProductAttribute> productAttributeList;

}
