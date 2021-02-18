package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/26 16:46
 */

@Setter
@Getter
public class UmsMenuNode extends UmsMenu{

    @ApiModelProperty(value = "子级菜单")
    private List<UmsMenuNode> children;
}
