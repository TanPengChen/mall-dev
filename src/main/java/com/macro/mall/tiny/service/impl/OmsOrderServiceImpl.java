package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.dao.OmsOrderDao;
import com.macro.mall.tiny.dao.OmsOrderOperateHistoryDao;
import com.macro.mall.tiny.dto.OmsOrderDetail;
import com.macro.mall.tiny.mbg.mapper.OmsOrderMapper;
import com.macro.mall.tiny.mbg.mapper.OmsOrderOperateHistoryMapper;
import com.macro.mall.tiny.mbg.model.*;
import com.macro.mall.tiny.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/9 9:39
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {

    @Autowired
    private OmsOrderDao orderDao;

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;

    @Autowired
    private OmsOrderOperateHistoryDao omsOrderOperateHistoryDao;

    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public OmsOrderDetail lisById(Long id) {
        return orderDao.getDetail(id);
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> omsOrderDeliveryParam) {
        //批量发货
        int count = orderDao.delivery(omsOrderDeliveryParam);
        //添加操作记录
        List<OmsOrderOperateHistory> operateHistoryList = omsOrderDeliveryParam.stream()
                .map(omsOrderDeliveryParam1 -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(omsOrderDeliveryParam1.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        return count;
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setId(id);
        omsOrder.setNote(note);
        omsOrder.setModifyTime(new Date());
        int count =  omsOrderMapper.updateByPrimaryKeySelective(omsOrder);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息：" + note);
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setDeleteStatus(1);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return omsOrderMapper.updateByExampleSelective(omsOrder,example);
    }

    @Override
    public int updateClose(List<Long> ids, String note) {
        OmsOrder record = new OmsOrder();
        record.setStatus(4);
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        int count = omsOrderMapper.updateByExampleSelective(record,example);
        List<OmsOrderOperateHistory> historyList = ids.stream().map(orderId ->{
            OmsOrderOperateHistory history = new OmsOrderOperateHistory();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管路员");
            history.setOrderStatus(4);
            history.setNote("订单关闭" + note);
            return history;
        }).collect(Collectors.toList());
        omsOrderOperateHistoryDao.insertList(historyList);
        return count;
    }

}
