package com.macro.mall.tiny.mbg.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/19 11:00
 */
@Setter
@Getter
public class SmsHomeRecommendSubject implements Serializable {

    private static final long serialVersionUID = -8803007703091504156L;

    private Integer id;

    private String subjectId;

    private String subjectName;

    private Integer recommendStatus;

    private Integer sort;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", subjectId=").append(subjectId);
        sb.append(", subjectName=").append(subjectName);
        sb.append(", recommendStatus=").append(recommendStatus);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
