package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnReason;
import com.macro.mall.tiny.service.OmsOrderReturnReasonService;
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
 * @date 2021/1/29 16:36
 */

@Api(tags = "OmsOrderReturnReasonController",description = "退货原因管理")
@Controller
@RequestMapping("/returnReason")
@CrossOrigin
public class OmsOrderReturnReasonController {

    @Autowired
    private OmsOrderReturnReasonService omsOrderReturnReasonService;


    @ApiOperation("分页查询退货信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderReturnReason>> list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                               @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
                                                               ){
        List<OmsOrderReturnReason> omsOrderReturnReasonList = omsOrderReturnReasonService.list(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(omsOrderReturnReasonList));

    }

    @ApiOperation("添加退货原因")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody OmsOrderReturnReason omsOrderReturnReason) throws Exception {
        int count = omsOrderReturnReasonService.create(omsOrderReturnReason);
        return CommonResult.success(count);
    }

    @ApiOperation("根据Id删除退货原因")
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids){
        int count = omsOrderReturnReasonService.delete(ids);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id查询退货信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OmsOrderReturnReason> listById(@PathVariable Long id){
      OmsOrderReturnReason list= omsOrderReturnReasonService.listById(id);
        return  CommonResult.success(list);
    }


    @ApiOperation("更新退货原因")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody OmsOrderReturnReason omsOrderReturnReason,@PathVariable Long id){
        int count = omsOrderReturnReasonService.update(omsOrderReturnReason,id);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("退货原因可用状态")
    @RequestMapping(value = "/update/status",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@RequestParam("status") Integer status,
                                     @RequestParam("ids") List<Long> ids
                                     ){
       int count = omsOrderReturnReasonService.updateStatus(status,ids);
       if (count > 0){
           return CommonResult.success(count);
       }else {
           return CommonResult.failed();
       }
    }
}
