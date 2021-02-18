package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.UmsMenu;
import com.macro.mall.tiny.mbg.model.UmsMenuNode;
import com.macro.mall.tiny.service.UmsMenuService;
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
 * @date 2021/1/15 19:40
 */

@CrossOrigin
@Controller
@RequestMapping("/menu")
@Api(tags = "UmsMenuController",description = "后台菜单管理")
public class UmsMenuController {

    @Autowired
    private UmsMenuService umsMenuService;


    @ApiOperation("分页查询菜单列表")
    @RequestMapping(value = "/list/{parentId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsMenu>> list(@PathVariable Long parentId,
                                                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
               List<UmsMenu> umsMenuList =  umsMenuService.list(parentId,pageNum,pageSize);
                return CommonResult.success(CommonPage.restPage(umsMenuList));
    }

    @ApiOperation("根据ID获取菜单详情")
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult<UmsMenu> getItem(@PathVariable Long id){
      UmsMenu menuList =  umsMenuService.getItem(id);
       return CommonResult.success(menuList);
    }

    @ApiOperation("修改后台菜单")
    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id,@RequestBody UmsMenu umsMenu){
        int count = umsMenuService.update(id,umsMenu);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("菜单列表隐藏")
    @RequestMapping(value = "/updateHidden/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateHidden(@PathVariable Long id,@RequestParam("hidden") Integer hidden){
        int count = umsMenuService.updateHidden(id,hidden);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsMenu umsMenu){
        int count  = umsMenuService.create(umsMenu);
        if (count > 0) {
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("根据ID删除后台管理菜单")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        int count = umsMenuService.delete(id);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "treeList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenuNode>> treeList(){
        List<UmsMenuNode> menuNodeList =  umsMenuService.treeList();
        return CommonResult.success(menuNodeList);
    }
}
