package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsHomeAdvertise;
import com.macro.mall.tiny.service.SmsHomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/18 14:32
 */

@Api(tags = "SmsHomeAdvertiseController",description = "首页广告轮播管理")
@RequestMapping("/home/advertise")
@Controller
@CrossOrigin
public class SmsHomeAdvertiseController {


    @Autowired
    private SmsHomeAdvertiseService smsHomeAdvertiseService;

    @ApiOperation("分页查询广告轮播列表")
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<SmsHomeAdvertise>> list(@RequestParam(value = "name",required = false) String name,
                                                           @RequestParam(value = "type",required = false) Integer type,
                                                           @RequestParam(value = "endTime",required = false)String endTime,
                                                           @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
                                                           ){
       List<SmsHomeAdvertise> smsHomeAdvertiseList =  smsHomeAdvertiseService.list(name,type,endTime,pageNum,pageSize);
       return CommonResult.success(CommonPage.restPage(smsHomeAdvertiseList));
    }
}
