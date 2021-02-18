package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.nosql.elasticsearch.document.EsProduct;
import com.macro.mall.tiny.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 搜索商品管理controller
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/24 17:25
 */

@Controller
@Api(tags = "EsProductController",description = "搜索商品管理")
@RequestMapping("/esProduct")
public class EsProductController {

    @Autowired
    private EsProductService esProductService;

    @ApiOperation("导入所有数据库的商品到ES")
    @RequestMapping(value = "/importAll",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAllList(){
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation("根据id删除商品")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@PathVariable Long id){
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation("根据ids批量删除商品")
    @RequestMapping(value = "/delete/batch",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Object> delete(@RequestParam("ids") List<Long> ids){
        esProductService.delete(ids);
        return CommonResult.success(null);
    }

    @ApiOperation("根据id创建商品")
    @RequestMapping(value = "/create/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<EsProduct> create(@PathVariable Long id){
        EsProduct esProduct = esProductService.create(id);
        if (esProduct == null){
            return CommonResult.failed("创建失败");
        }
        return CommonResult.success(esProduct);
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsProduct> esProductPage = esProductService.search(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }
    
}
