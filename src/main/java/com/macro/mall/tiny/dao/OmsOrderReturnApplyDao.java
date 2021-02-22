package com.macro.mall.tiny.dao;

import com.macro.mall.tiny.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.dto.QueryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderReturnApplyDao {

    List<OmsOrderReturnApply> getList(@Param("queryParam") QueryParam queryParam);

    OmsOrderReturnApplyResult getDetail(Long id);
}
