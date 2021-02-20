package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SmsHomeNewProduct;
import com.macro.mall.tiny.mbg.model.SmsHomeNewProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsHomeNewProductMapper {

    List<SmsHomeNewProduct> selectByExample(SmsHomeNewProductExample example);

    int updateByExampleSelective(@Param("example") SmsHomeNewProductExample example,@Param("record") SmsHomeNewProduct homeNewProduct);

    int updateByPrimaryKeySelective(SmsHomeNewProduct record);

    void insert(SmsHomeNewProduct homeNewProduct);

    int deleteByExample(SmsHomeNewProductExample example);
}
