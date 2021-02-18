package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.UmsMenu;
import com.macro.mall.tiny.mbg.model.UmsResource;
import com.macro.mall.tiny.mbg.model.UmsRole;
import com.macro.mall.tiny.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/13 20:21
 */

@Controller
@Api(tags = "UmsRoleController",description = "后台用户角色管理")
@RequestMapping("/role")
@CrossOrigin
public class UmsRoleController {

    @Autowired
    private UmsRoleService roleService;

    @ApiOperation("角色列表")
    @ResponseBody
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public CommonResult<List<UmsRole>> listAll(){
        List<UmsRole> umsRoleList = roleService.list();
        return CommonResult.success(umsRoleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword",required = false) String keyword,
                                            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<UmsRole> umsRoleList = roleService.list(keyword,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(umsRoleList));
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable("id") Long id,
                                     @RequestParam("status") Integer status){
        int count = roleService.updateStatus(id,status);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("添加新角色")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsRole umsRole){
        int count = roleService.create(umsRole);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = roleService.delete(ids);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("编辑角色")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Long id,
                               @RequestBody UmsRole umsRole
                               ){
        int count = roleService.update(id, umsRole);
        if(count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocMenu(@RequestParam Long roleId,@RequestParam List<Long> menuIds){
        int count = roleService.allocMenu(roleId,menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("获取角色相关菜单")
    @RequestMapping(value = "/listMenu/{roleId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult listMenu(@PathVariable("roleId") Long roleId){
        List<UmsMenu> umsMenuList = roleService.listMenu(roleId);
        return CommonResult.success(umsMenuList);

    }

    @ApiOperation("根据ID获取后台资源列表")
    @RequestMapping("/listResource/{id}")
    @ResponseBody
    public CommonResult listResource(@PathVariable("id") Long id){
        List<UmsResource> umsResourceList = roleService.listResource(id);
        return CommonResult.success(umsResourceList);
    }


    @ApiOperation("给角色分配资源")
    @RequestMapping(value = "/allocResource",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocResource(@RequestParam Long roleId,@RequestParam List<Long> resourceIds){
        int count = roleService.allocResource(roleId, resourceIds);
        return CommonResult.success(count);
    }
}
