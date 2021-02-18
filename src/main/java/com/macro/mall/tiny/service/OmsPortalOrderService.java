package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.OrderParam;
import com.macro.mall.tiny.mbg.model.OmsOrderDetail;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/26 8:57
 */

public interface OmsPortalOrderService {

    /**
     *取消单个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * 根据提交信息生产订单
     * @param orderParam
     * @return
     */
    CommonResult generateOrder(OrderParam orderParam);

    CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

    /**
     * 分页查询订单列表信息
     * @param status
     * @param pageNum
     * @param pageSize
     * @return
     */
    //CommonPage<OmsOrderDetail> list(Integer status, Integer pageNum, Integer pageSize);

}
