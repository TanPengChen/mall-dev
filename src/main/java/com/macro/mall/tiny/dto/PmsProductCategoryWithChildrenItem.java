package com.macro.mall.tiny.dto;

import com.macro.mall.tiny.mbg.model.PmsProductCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/29 11:17
 */

public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {

    @Setter
    @Getter
    @ApiModelProperty("子级分类")
    private List<PmsProductCategory> children;
}
