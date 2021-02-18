package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.tiny.mbg.model.PmsProductCategory;
import com.macro.mall.tiny.mbg.model.PmsProductCategoryParam;
import com.macro.mall.tiny.service.PmsProductCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "PmsProductCategoryController",value = "商品分类管理")
@Controller
@RequestMapping("/productCategory")
@CrossOrigin
public class PmsProductCategoryController {

    @Autowired
    private PmsProductCategoryService productCategoryService;


    @ApiOperation("查询所有一级分类及其子类")
    @RequestMapping(value = "/list/withChildren",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsProductCategoryWithChildrenItem>> listWithChildren(){
        List<PmsProductCategoryWithChildrenItem> list = productCategoryService.listWithChildren();
        return CommonResult.success(list);
    }


    @ApiOperation("分页查询商品分类")
    @RequestMapping(value = "/list/{parentId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProductCategory>> getList(@PathVariable Long parentId,
                                                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNum){
        List<PmsProductCategory> productCategoryList = productCategoryService.getList(parentId,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(productCategoryList));
    }

    @ApiOperation("添加产品分类")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsProductCategoryParam pmsProductCategoryParam ){
        int count = productCategoryService.create(pmsProductCategoryParam);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

}
