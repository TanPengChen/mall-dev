package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.UmsMemberLevel;
import com.macro.mall.tiny.service.UmsMemberLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2021/2/24 10:37
 */

@Api(tags = "UmsMemberLevelController",description = "会员等级管理")
@RequestMapping("/memberLevel")
@CrossOrigin
@Controller
public class UmsMemberLevelController {

    @Autowired
    private UmsMemberLevelService umsMemberLevelService;


    @ApiOperation("")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMemberLevel>> list(@RequestParam("defaultStatus")Integer defaultStatus){
        List<UmsMemberLevel> memberLevelList = umsMemberLevelService.list(defaultStatus);
        return CommonResult.success(memberLevelList);
    }


}
