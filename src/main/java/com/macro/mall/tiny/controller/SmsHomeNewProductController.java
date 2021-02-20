package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsHomeNewProduct;
import com.macro.mall.tiny.service.SmsHomeNewProductService;
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
 * @date 2021/2/20 11:08
 */

@Controller
@CrossOrigin
@RequestMapping("/home/newProduct")
@Api(tags = "SmsHomeNewProductController",description = "首页新品管理")
public class SmsHomeNewProductController {

    @Autowired
    private SmsHomeNewProductService smsHomeNewProductService;

    @ApiOperation("分页查询首页新品列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeNewProduct>> list(@RequestParam(value = "productName",required = false) String productName,
                                                            @RequestParam(value = "recommendStatus",required = false) Integer recommendStatus,
                                                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
                                                            ){
        List<SmsHomeNewProduct> homeNewProductList = smsHomeNewProductService.list(productName,recommendStatus,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(homeNewProductList));
    }


    @ApiOperation("新品推荐")
    @RequestMapping(value = "/update/recommendStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,Integer recommendStatus ){
       int count = smsHomeNewProductService.updateRecommendStatus(ids,recommendStatus);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }
    }

    @ApiOperation("排序设置")
    @RequestMapping(value = "/update/sort/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateSort(@PathVariable Long id,Integer sort){
        int count = smsHomeNewProductService.updateSort(id,sort);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("添加新品推荐")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody List<SmsHomeNewProduct> smsHomeNewProduct){
           int count = smsHomeNewProductService.create(smsHomeNewProduct);
           if (count > 0){
               return CommonResult.success(count);
           }else {
               return CommonResult.failed();
           }
    }

    @ApiOperation("根据ID删除商品推荐")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count  = smsHomeNewProductService.delete(ids);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
}
