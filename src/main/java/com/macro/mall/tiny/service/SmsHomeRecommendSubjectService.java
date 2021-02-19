package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SmsHomeRecommendSubject;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/19 11:19
 */

public interface SmsHomeRecommendSubjectService {

    List<SmsHomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
