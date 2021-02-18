package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.mbg.mapper.OmsOrderReturnReasonMapper;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnReason;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnReasonExample;
import com.macro.mall.tiny.service.OmsOrderReturnReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/29 16:44
 */
@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {

    @Autowired
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;

    @Override
    public List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.setOrderByClause("sort desc");
        return omsOrderReturnReasonMapper.selectByExample(example);
    }

    @Override
    public int create(OmsOrderReturnReason omsOrderReturnReason) throws Exception {
            return omsOrderReturnReasonMapper.insert(omsOrderReturnReason);
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return omsOrderReturnReasonMapper.deleteByExample(example);
    }

    @Override
    public OmsOrderReturnReason listById(Long id) {
        return omsOrderReturnReasonMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(OmsOrderReturnReason omsOrderReturnReason, Long id) {
        omsOrderReturnReason.setId(id);
        return omsOrderReturnReasonMapper.updateByPrimaryKey(omsOrderReturnReason);
    }

    @Override
    public int updateStatus(Integer status, List<Long> ids) {
        if (!status.equals(0)&&!status.equals(1)){
            return 0;
        }
        OmsOrderReturnReason record = new OmsOrderReturnReason();
        record.setStatus(status);
        OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
        example.createCriteria().andIdIn(ids);
        return omsOrderReturnReasonMapper.updateByExampleSelective(record,example);
    }


}
