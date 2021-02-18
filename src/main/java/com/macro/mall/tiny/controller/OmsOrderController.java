package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.OmsOrder;
import com.macro.mall.tiny.mbg.model.OmsOrderQueryParam;
import com.macro.mall.tiny.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/9 9:37
 */

@Api(tags = "OmsOrderController",description = "订单管理")
@RequestMapping("/order")
@Controller
@CrossOrigin
public class OmsOrderController {


    @Autowired
    private OmsOrderService omsOrderService;


    @ApiOperation("分页查询订单管理列表")
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<OmsOrder>> list(OmsOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
                                                   ){

        List<OmsOrder> omsOrderList = omsOrderService.list(queryParam,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(omsOrderList));

    }

}
