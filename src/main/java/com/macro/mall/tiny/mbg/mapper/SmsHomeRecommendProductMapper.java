package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsHomeRecommendProduct;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsHomeRecommendProductMapper {

    List<SmsHomeRecommendProduct> selectByExample(SmsHomeRecommendProductExample example);

    int updateByExampleSelective(@Param("example") SmsHomeRecommendProductExample example,@Param("record") SmsHomeRecommendProduct recommendProduct);

    int updateByPrimaryKeySelective(SmsHomeRecommendProduct recommendProduct);

    int insertSelective(List<SmsHomeRecommendProduct> smsHomeRecommendProduct);

    void insert(SmsHomeRecommendProduct homeRecommendProduct);

    int deleteByExample(SmsHomeRecommendProductExample example);
}
