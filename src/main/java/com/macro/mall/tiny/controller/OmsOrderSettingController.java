package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.OmsOrderSetting;
import com.macro.mall.tiny.service.OmsOrderSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/29 10:05
 */

@Api(tags = "OmsOrderSettingController",description = "订单设置Controller")
@RequestMapping("/orderSetting")
@CrossOrigin
@Controller
public class OmsOrderSettingController {

    @Autowired
    private OmsOrderSettingService omsOrderSettingService;


    @ApiOperation("查询订单设置")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderSetting> getItem(@PathVariable Long id){
      OmsOrderSetting orderSettingList = omsOrderSettingService.orderSetting(id);
        return CommonResult.success(orderSettingList);
    }

    @ApiOperation("更新订单设置")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody OmsOrderSetting omsOrderSetting){
       int count = omsOrderSettingService.update(id,omsOrderSetting);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }

    }
}
