package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.OmsOrderDetail;
import com.macro.mall.tiny.mbg.model.OmsOrder;
import com.macro.mall.tiny.mbg.model.OmsOrderDeliveryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderQueryParam;
import com.macro.mall.tiny.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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


    @ApiOperation("订单详情")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderDetail> listById(@PathVariable Long id){
        OmsOrderDetail omsOrderList = omsOrderService.lisById(id);
      return CommonResult.success(omsOrderList);
    }

    @ApiModelProperty("订单发货")
    @RequestMapping(value = "/update/delivery",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody List<OmsOrderDeliveryParam> omsOrderDeliveryParam){
      int count =   omsOrderService.delivery(omsOrderDeliveryParam);
      if (count > 0){
          return CommonResult.success(count);
      }else {
          return CommonResult.failed();
      }
    }

    @RequestMapping(value = "/update/note",method = RequestMethod.POST)
    @ApiOperation("备注订单")
    @ResponseBody
    public CommonResult updateNote(@RequestParam("id") Long id,
                                   @RequestParam("note") String note,
                                   @RequestParam("status") Integer status
                                    ){
        int count = omsOrderService.updateNote(id,note,status);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = omsOrderService.delete(ids);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }

    }
}
