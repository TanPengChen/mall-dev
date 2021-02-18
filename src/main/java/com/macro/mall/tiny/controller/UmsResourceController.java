package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.UmsResource;
import com.macro.mall.tiny.service.UmsResourceService;
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
 * @date 2021/1/15 13:08
 */
@Controller
@CrossOrigin
@Api(tags = "UmsResourceController",description = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {

    @Autowired
    private UmsResourceService resourceService;

//    @Autowired
//    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;


    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsResource>> list(@RequestParam(required = false) Long categoryId,
                                                @RequestParam(required = false) String nameKeyword,
                                                @RequestParam(required = false) String urlKeyword,
                                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
           List<UmsResource>  umsResourceList  =  resourceService.list(categoryId,nameKeyword,urlKeyword,pageNum,pageSize);
           return CommonResult.success(CommonPage.restPage(umsResourceList));
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable(value = "id") Long id,@RequestBody UmsResource umsResource){
        int count = resourceService.update(id,umsResource);
        if (count > 0 ){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("后台资源添加管理")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResource umsResource){
        int count = resourceService.create(umsResource);
        //dynamicSecurityMetadataSource.clearDataSource(umsResource);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }

    }


    @ApiOperation("根据ID删除资源")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable(value = "id") Long id){
       int count =  resourceService.delete(id);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResource>> listAll(){
      List<UmsResource> umsResourceList =   resourceService.listAll();
      return CommonResult.success(umsResourceList);
    }
}
