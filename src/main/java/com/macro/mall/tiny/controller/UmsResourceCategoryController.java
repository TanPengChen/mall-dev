package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.UmsResourceCategory;
import com.macro.mall.tiny.service.UmsResourceCategoryService;
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
 * @date 2021/1/15 12:37
 */

@Controller
@CrossOrigin
@RequestMapping("/resourceCategory")
@Api(tags = "UmsResourceCategoryController",description = "资源后台管理")
public class UmsResourceCategoryController {


    @Autowired
    private UmsResourceCategoryService umsResourceCategoryService;



    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResourceCategory>> listAll(){
       List<UmsResourceCategory> roleList =  umsResourceCategoryService.listAll();
       return CommonResult.success(roleList);
    }

    @ApiOperation("添加分类")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResourceCategory umsResourceCategory) throws Exception {
       int count =  umsResourceCategoryService.create(umsResourceCategory);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }

    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        int count = umsResourceCategoryService.delete(id);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("添加分类")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody UmsResourceCategory umsResourceCategory ) throws Exception {
        int count = umsResourceCategoryService.update(id,umsResourceCategory);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }

    }
}
