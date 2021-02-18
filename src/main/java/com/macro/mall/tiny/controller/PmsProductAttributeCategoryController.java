package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategory;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeCategoryItem;
import com.macro.mall.tiny.service.PmsProductAttributeCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Api(tags = "PmsProductAttributeCategoryController",description = "商品属性分类")
@RequestMapping("/productAttribute/category")
@Controller
@CrossOrigin
public class PmsProductAttributeCategoryController {

    @Autowired
    private PmsProductAttributeCategoryService pmsProductAttributeCategoryService;


    @ApiOperation("分页获取所有商品属性分类")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProductAttributeCategory>> getList(@RequestParam(defaultValue = "5") Integer pageSize ,
                                                                         @RequestParam(defaultValue = "1") Integer pageNum){

       List<PmsProductAttributeCategory> productAttributeCategoryList =  pmsProductAttributeCategoryService.getList(pageNum,pageSize);
       return CommonResult.success(CommonPage.restPage(productAttributeCategoryList));
    }

    @ApiOperation("获取所有商品属性分类及其下属性")
    @RequestMapping(value = "/list/withAttr",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductAttributeCategoryItem>> getListWithAttr(){
        List<PmsProductAttributeCategoryItem> pmsProductCategoryWithChildrenItems = pmsProductAttributeCategoryService.getListWithAttr();
        return CommonResult.success(pmsProductCategoryWithChildrenItems);
    }

    @ApiOperation("")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestParam String name){
        int count = pmsProductAttributeCategoryService.create(name);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除单个商品属性分类")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id){
       int count =  pmsProductAttributeCategoryService.delete(id);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }
    }
}
