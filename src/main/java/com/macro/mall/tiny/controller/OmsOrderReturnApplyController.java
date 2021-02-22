package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.OmsOrderReturnApplyResult;
import com.macro.mall.tiny.dto.OmsUpdateStatusParam;
import com.macro.mall.tiny.dto.QueryParam;
import com.macro.mall.tiny.mbg.model.OmsOrderReturnApply;
import com.macro.mall.tiny.service.OmsOrderReturnApplyService;
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
 * @date 2021/1/29 14:12
 */

@Api(tags = "OmsOrderReturnApplyController",description = "退货申请管理Controller")
@RequestMapping("/returnApply")
@CrossOrigin
@Controller
public class OmsOrderReturnApplyController {

    @Autowired
    private OmsOrderReturnApplyService omsOrderReturnApplyService;

    @ApiOperation("分页查询退货订单列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody  //OmsReturnApplyQueryParam
    public CommonResult<CommonPage<OmsOrderReturnApply>> list(QueryParam queryParam,
                                                              @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
                                                              ){
        List<OmsOrderReturnApply> omsOrderReturnApplyList = omsOrderReturnApplyService.list(queryParam,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(omsOrderReturnApplyList));
    }

    @ApiOperation("退货原因详情")
    @RequestMapping("/{id}")
    @ResponseBody
    public CommonResult listById(@PathVariable Long id){
        OmsOrderReturnApplyResult listById = omsOrderReturnApplyService.listById(id);
        return CommonResult.success(listById);
    }

    @ApiOperation("确认退货")
    @ResponseBody
    @RequestMapping(value = "/update/status/{id}",method = RequestMethod.POST)
    public CommonResult updateStatus(@PathVariable Long id, @RequestBody OmsUpdateStatusParam statusParam){
        int count = omsOrderReturnApplyService.updateStatus(id,statusParam);
        if (count >0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
}
