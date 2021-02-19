package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsHomeRecommendSubject;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendSubjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/19 12:55
 */

public interface SmsHomeRecommendSubjectMapper {

    List<SmsHomeRecommendSubject> selectByExample(SmsHomeRecommendSubjectExample example);

    int updateByExampleSelective(@Param("record") SmsHomeRecommendSubject record, @Param("example") SmsHomeRecommendSubjectExample example);

    int updateByPrimaryKeySelective(SmsHomeRecommendSubject subject);

    int deleteByExample(SmsHomeRecommendSubjectExample example);
}
