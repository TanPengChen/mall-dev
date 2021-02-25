package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.PmsProductParam;
import com.macro.mall.tiny.dto.PmsProductQueryParam;
import com.macro.mall.tiny.mbg.model.PmsProduct;
import com.macro.mall.tiny.service.PmsProductService;
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
 * @date 2021/1/17 9:56
 */

@CrossOrigin
@Controller
@RequestMapping("/product")
@Api(tags = "PmsProductController",description = "商品管理")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;


    @ApiOperation("创建商品")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsProductParam pmsProductParam){
       int count =  pmsProductService.create(pmsProductParam);
       if (count>0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }
    }

    @ApiOperation("分页查询商品列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> getList(PmsProductQueryParam pmsProductQueryParam,
                                                     @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
                                                     ){
               List<PmsProduct> pmsProductList =  pmsProductService.list(pmsProductQueryParam,pageNum,pageSize);
               return CommonResult.success(CommonPage.restPage(pmsProductList));
    }

    @ApiOperation("批量设为新品")
    @RequestMapping(value = "/update/newStatus",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult newStatusUpdate(@RequestParam("ids") List<Long> ids,
                               @RequestParam("newStatus") Integer newStatus
                               ){
        int count = pmsProductService.newStatus(ids,newStatus);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }

    }


    @ApiOperation("批量设为上架")
    @RequestMapping("/update/publishStatus")
    @ResponseBody
    public CommonResult publishStatusUpdate(@RequestParam("ids") List<Long> ids,
                                            @RequestParam("publishStatus") Integer publishStatus
                                            ){
        int count = pmsProductService.publishStatus(ids,publishStatus);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量修改推荐")
    @RequestMapping("/update/recommendStatus")
    @ResponseBody
    public CommonResult recommendStatusUpdate(@RequestParam("ids") List<Long> ids,
                                              @RequestParam("recommendStatus") Integer recommendStatus
                                              ){
        int count = pmsProductService.recommendStatus(ids,recommendStatus);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
}
