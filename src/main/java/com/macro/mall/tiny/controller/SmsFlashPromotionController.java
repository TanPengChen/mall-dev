package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotion;
import com.macro.mall.tiny.service.SmsFlashPromotionService;
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
 * @date 2021/2/20 16:13
 */

@Api(tags = "SmsFlashPromotionController",description = "秒杀活动管理")
@CrossOrigin
@Controller
@RequestMapping("/flash")
public class SmsFlashPromotionController {

    @Autowired
    private SmsFlashPromotionService smsFlashPromotionService;



    @ApiOperation("添加秒杀项目")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody SmsFlashPromotion smsFlashPromotion){
        int count = smsFlashPromotionService.create(smsFlashPromotion);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("秒杀活动列表")
    @ResponseBody
    public CommonResult<CommonPage<SmsFlashPromotion>> list(@RequestParam(value = "title",required = false) String title,
                                                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
                                                            ){
        List<SmsFlashPromotion> smsFlashPromotionList = smsFlashPromotionService.list(title,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(smsFlashPromotionList));
    }

    @RequestMapping(value = "/delete/{id}",method =RequestMethod.POST)
    @ApiOperation("根据ID删除秒杀活动项目")
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        int count = smsFlashPromotionService.delete(id);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("秒杀活动修改")
    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id,@RequestBody SmsFlashPromotion smsFlashPromotion ){
        int count = smsFlashPromotionService.update(id,smsFlashPromotion);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("秒杀活动上/下线")
    @ResponseBody
    @RequestMapping(value = "/update/status/{id}",method = RequestMethod.POST)
    public CommonResult updateStatus(@PathVariable Long id,Integer status){
       int count = smsFlashPromotionService.updateStatus(id,status);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }

    }
}
