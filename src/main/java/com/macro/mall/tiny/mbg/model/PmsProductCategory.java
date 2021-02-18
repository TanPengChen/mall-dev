package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/29 11:10
 */

@Getter
@Setter
public class PmsProductCategory implements Serializable{

    private static final long serialVersionUID = -5314969426348579349L;

   private Long id;

   @ApiModelProperty(value = "上机分类的编号：0表示一级分类")
   private Long parentId;

   private String name;

   @ApiModelProperty(value = "分类级别：0->1级；1->2级")
   private Integer level;

   private Integer productCount;

   private String productUnit;

   @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
   private Integer navStatus;

   @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
   private Integer showStatus;

   private Integer sort;

   @ApiModelProperty(value = "图标")
   private String icon;

   private String keywords;

   @ApiModelProperty(value = "描述")
    private String description;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", level=").append(level);
        sb.append(", productCount=").append(productCount);
        sb.append(", productUnit=").append(productUnit);
        sb.append(", navStatus=").append(navStatus);
        sb.append(", showStatus=").append(showStatus);
        sb.append(", sort=").append(sort);
        sb.append(", icon=").append(icon);
        sb.append(", keywords=").append(keywords);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
