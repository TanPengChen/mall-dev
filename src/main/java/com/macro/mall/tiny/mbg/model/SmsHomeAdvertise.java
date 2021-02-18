package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/18 14:22
 */

@Getter
@Setter
public class SmsHomeAdvertise implements Serializable {

    private static final long serialVersionUID = -301871502295021231L;

    private Long id;

    private String pic;

    @ApiModelProperty(value = "轮播位置：0->PC首页轮播；1->app首页轮播")
    private Integer type;

    private String name;

    private Date startTime;

    private Date endTime;

    @ApiModelProperty(value = "上下线状态：0->下线，1->上线")
    private Integer status;

    @ApiModelProperty(value = "点击数")
    private Integer clickCount;

    @ApiModelProperty(value = "下载数")
    private Integer orderCount;

    @ApiModelProperty(value = "链接地址")
    private String url;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", pic=").append(pic);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", orderCount=").append(orderCount);
        sb.append(", url=").append(url);
        sb.append(", note=").append(note);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
