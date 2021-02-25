package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.PmsProduct;
import com.macro.mall.tiny.mbg.model.PmsProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/17 10:32
 */

public interface PmsProductMapper {

    List<PmsProduct> selectByExample(PmsProductExample example);

    int updateByExampleSelective(@Param("record") PmsProduct record,@Param("example") PmsProductExample example);

    void insertSelective(PmsProduct pmsProduct);

}
