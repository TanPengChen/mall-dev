package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.component.CancelOrderSender;
import com.macro.mall.tiny.dto.OrderParam;
import com.macro.mall.tiny.mbg.mapper.OmsOrderMapper;
import com.macro.mall.tiny.mbg.model.OmsOrderDetail;
import com.macro.mall.tiny.mbg.model.OmsOrderExample;
import com.macro.mall.tiny.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 前台订单Service
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/26 9:06
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {

    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Autowired
    protected OmsOrderMapper orderMapper;

    @Override
    public void cancelOrder(Long orderId) {
        //todo 执行一系类取消订单操作，具体参考mall项目
        LOGGER.info("process cancelOrder orderId:{}",orderId);

    }

    private void sendDelayMessageCancelOrder(long orderId) {

        //获取订单超时时间，假设是60分钟
        long delayTimes = 30 *1000;

        //发送延迟消息
        cancelOrderSender.sendMessage(orderId,delayTimes);

    }

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        LOGGER.info("process generateOrder");
        //下单完成后开启一个延迟消息，用于用户没有付款时取消订单(OrderId应该在下单后生成)
        sendDelayMessageCancelOrder(11L);
        return CommonResult.success(null,"下单成功");

    }

    @Override
    public CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize) {
        return null;
    }

   /* @Override
    public CommonPage<OmsOrderDetail> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        OmsOrderExample example = new OmsOrderExample();
        example.setOrderByClause("create_time desc");
        CommonPage<OmsOrderDetail> orderList = orderMapper.selectByExample(example);
        return orderList;
    }*/
}
