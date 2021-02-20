package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsHomeBrand;
import com.macro.mall.tiny.service.SmsHomeBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/20 13:58
 */

@Api(tags = "SmsHomeBrandController",description = "首页品牌管理")
@RequestMapping("/home/brand")
@CrossOrigin
@Controller
public class SmsHomeBrandController {

    @Autowired
    private SmsHomeBrandService smsHomeBrandService;


    @ApiOperation("分页查询推荐品牌")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeBrand>> list(@RequestParam(value = "brandName", required = false) String brandName,
                                                       @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
    ) {
        List<SmsHomeBrand> smsHomeBrandList = smsHomeBrandService.list(brandName, recommendStatus, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(smsHomeBrandList));
    }

    @ApiOperation("添加品牌推荐")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody List<SmsHomeBrand> smsHomeBrand) {
        int count = smsHomeBrandService.create(smsHomeBrand);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据Id删除品牌管理")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = smsHomeBrandService.detele(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("品牌推荐排序")
    @ResponseBody
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    public CommonResult updateSort(@PathVariable("id") Long id, Integer sort) {
        int count = smsHomeBrandService.updateSort(id, sort);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("品牌推荐排序")
    @ResponseBody
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids, Integer recommendStatus) {
        int count = smsHomeBrandService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();

        }
    }

}
