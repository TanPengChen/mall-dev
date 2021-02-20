package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendProduct;
import com.macro.mall.tiny.service.SmsHomeRecommendProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/19 17:27
 */

@Api(tags = "SmsHomeRecommendProductController",description = "首页人气推荐管理")
@RequestMapping("/home/recommendProduct")
@Controller
@CrossOrigin
public class SmsHomeRecommendProductController {

    @Autowired
    private SmsHomeRecommendProductService smsHomeRecommendProductService;


    @ApiOperation("分页查询人气推荐列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeRecommendProduct>> list(@RequestParam(value = "productName",required = false) String productName,
                                                                  @RequestParam(value = "recommendStatus",required = false) Integer recommendStatus,
                                                                  @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
                             ){
        List<SmsHomeRecommendProduct> smsHomeRecommendProductList = smsHomeRecommendProductService.list(productName,recommendStatus,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(smsHomeRecommendProductList));

    }

    @ApiOperation("人气推荐管理")
    @RequestMapping(value = "/update/recommendStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,Integer recommendStatus ){
        int count = smsHomeRecommendProductService.updateRecommendStatus(ids,recommendStatus);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("人气排序推荐")
    @RequestMapping(value = "/update/sort/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateSort(@PathVariable Long id,Integer sort){
       int count = smsHomeRecommendProductService.updateSort(id,sort);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }
    }

    @ApiOperation("添加首页人气推荐")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody List<SmsHomeRecommendProduct> smsHomeRecommendProduct ){
           int count = smsHomeRecommendProductService.create(smsHomeRecommendProduct);
           if (count >0 ){
               return CommonResult.success(count);
           }else {
               return CommonResult.failed();
           }
    }

    @ApiOperation("根据ID删除首页人气推荐")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
       int count =  smsHomeRecommendProductService.delete(ids);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }

    }
}
