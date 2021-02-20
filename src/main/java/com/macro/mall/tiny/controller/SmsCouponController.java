package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsCoupon;
import com.macro.mall.tiny.service.SmsCouponService;
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
 * @date 2021/2/20 15:08
 */

@Api(tags = "SmsCouponController",description = "优惠劵管理")
@Controller
@CrossOrigin
@RequestMapping("/coupon")
public class SmsCouponController {

    @Autowired
    private SmsCouponService smsCouponService;


    @ApiOperation("分页查询优惠劵列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsCoupon>> list(@RequestParam(value = "name",required = false) String name,
                                         @RequestParam(value = "type",required = false) Integer type,
                                         @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
                             ){
       List<SmsCoupon> smsCouponList = smsCouponService.list(name,type,pageNum,pageSize);
       return CommonResult.success(CommonPage.restPage(smsCouponList));

    }

    @ApiOperation("根据ID删除优惠劵列表")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        int count = smsCouponService.delete(id);
        if (count > 0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }

    }
}
