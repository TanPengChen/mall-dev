package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.OmsOrderReturnReason;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnReasonExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/29 16:49
 */

public interface OmsOrderReturnReasonMapper {

    List<OmsOrderReturnReason> selectByExample(OmsOrderReturnReasonExample example);

    int insert(OmsOrderReturnReason record);

    int deleteByExample(OmsOrderReturnReasonExample example);

    OmsOrderReturnReason selectByPrimaryKey(Long id);

    int updateByPrimaryKey(OmsOrderReturnReason record);

    int updateByExampleSelective(@Param("record") OmsOrderReturnReason record,@Param("example") OmsOrderReturnReasonExample example);
}
