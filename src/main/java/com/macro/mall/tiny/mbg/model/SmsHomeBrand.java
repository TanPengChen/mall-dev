package com.macro.mall.tiny.mbg.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 13:55
 */

@Setter
@Getter
public class SmsHomeBrand implements Serializable {

    private static final long serialVersionUID = 7972953407278169549L;

    private Long id;

    private Long brandId;

    private String brandName;

    private Integer recommendStatus;

    private Integer sort;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandId=").append(brandId);
        sb.append(", brandName=").append(brandName);
        sb.append(", recommendStatus=").append(recommendStatus);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
