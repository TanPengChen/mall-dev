package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.CmsPrefrenceArea;
import com.macro.mall.tiny.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/23 16:40
 */

@CrossOrigin
@Controller
@RequestMapping("/prefrenceArea")
@Api(tags = "CmsPrefrenceAreaController",description = "商品优选管理")
public class CmsPrefrenceAreaController {

    @Autowired
    private CmsPrefrenceAreaService cmsPrefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @ResponseBody
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    public CommonResult<List<CmsPrefrenceArea>> listAll(){
        List<CmsPrefrenceArea> prefrenceAreaList =  cmsPrefrenceAreaService.listAll();
        return CommonResult.success(prefrenceAreaList);
    }
}
