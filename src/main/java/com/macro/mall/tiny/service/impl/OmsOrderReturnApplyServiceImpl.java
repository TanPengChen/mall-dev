package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dao.OmsOrderReturnApplyDao;
import com.macro.mall.tiny.dto.QueryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnApply;
import com.macro.mall.tiny.service.OmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/29 15:08
 */
@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {

    @Autowired
    private OmsOrderReturnApplyDao omsOrderReturnApplyDao;

    @Override
    public List<OmsOrderReturnApply> list(QueryParam queryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return omsOrderReturnApplyDao.getList(queryParam);
    }
}
