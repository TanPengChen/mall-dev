package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsHomeBrand;
import com.macro.mall.tiny.mbg.model.SmsHomeBrandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsHomeBrandMapper {

    List<SmsHomeBrand> selectByExample(SmsHomeBrandExample example);

    int deleteByExample(SmsHomeBrandExample example);

    void insert(SmsHomeBrand homeBrand);

    int updateByPrimaryKeySelective(SmsHomeBrand smsHomeBrand);

    int updateByExampleSelective(@Param("example") SmsHomeBrandExample example,@Param("record") SmsHomeBrand smsHomeBrand);
}
