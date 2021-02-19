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


    @ApiOperation("添加广告")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsHomeAdvertise homeAdvertise){
        int count = smsHomeAdvertiseService.create(homeAdvertise);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除广告")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") Long ids){
        int count = smsHomeAdvertiseService.delete(ids);
        if (count> 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

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

    @ApiOperation("更新上线/下线状态")
    @RequestMapping(value = "/update/status/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id,Integer status){
            int count = smsHomeAdvertiseService.updateStatus(id,status);
            if (count > 0){
                return CommonResult.success(count);
            }else {
                return CommonResult.failed();
            }
    }

    @ApiOperation("通过ID查询广告详情")
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult<List<SmsHomeAdvertise>> getItem(@PathVariable Long id){
             List<SmsHomeAdvertise> smsHomeAdvertiseList =smsHomeAdvertiseService.getItem(id);
             return CommonResult.success(smsHomeAdvertiseList);
    }

    @ApiOperation("修改广告")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody SmsHomeAdvertise advertise) {
        int count = smsHomeAdvertiseService.update(id, advertise);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }
}
