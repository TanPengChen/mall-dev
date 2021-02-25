package com.macro.mall.tiny.dao;


import com.macro.mall.tiny.mbg.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员价格
 */
public interface PmsMemberPriceDao {

    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
