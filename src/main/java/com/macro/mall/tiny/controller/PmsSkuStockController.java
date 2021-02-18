package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.PmsSkuStock;
import com.macro.mall.tiny.service.PmsSkuStockService;
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
 * @date 2021/1/26 13:22
 */

@Api(tags = "PmsSkuStockController",description = "SKU库存管理Controller")
@RequestMapping("/sku")
@Controller
@CrossOrigin
public class PmsSkuStockController {


    @Autowired
     private PmsSkuStockService pmsSkuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/{pid}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsSkuStock>> getList(@PathVariable("pid") Long pid,
                                                   @RequestParam(value = "keyword",required = false) String keyword){
        List<PmsSkuStock> skuStockList = pmsSkuStockService.getList(pid,keyword);
        return CommonResult.success(skuStockList);
    }

    @ApiOperation("")
    @RequestMapping(value = "/update/{pid}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("pid") Long pid,
                               @RequestBody List<PmsSkuStock> skuStockList){
        int count = pmsSkuStockService.update(pid,skuStockList);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
}
