package com.macro.mall.tiny.controller;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/1/22 13:41
 */

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.PmsProductAttribute;
import com.macro.mall.tiny.mbg.model.PmsProductAttributeParam;
import com.macro.mall.tiny.service.PmsProductAttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "PmsProductAttributeController",description = "商品属性管理")
@RequestMapping("/productAttribute")
@Controller
@CrossOrigin
public class PmsProductAttributeController {

    @Autowired
    private PmsProductAttributeService pmsProductAttributeService;

    @ApiOperation("分页查询商品属性列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "type",value = "0表示属性，1表示参数",required = true,paramType = "query",dataType = "integer")})
    @RequestMapping(value = "/list/{cid}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProductAttribute>> getList(@PathVariable Long cid,
                                                                   @RequestParam(value = "type") Integer type,
                                                                   @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                                   @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize
                             ){
        List<PmsProductAttribute> pmsProductAttributeList = pmsProductAttributeService.getList(cid,type,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(pmsProductAttributeList));

    }

    @ApiOperation("添加商品属性信息")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsProductAttributeParam pmsProductAttributeParam){
        int count = pmsProductAttributeService.create(pmsProductAttributeParam);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("批量删除商品属性")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = pmsProductAttributeService.delete(ids);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
}
