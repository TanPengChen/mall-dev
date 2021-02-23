package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.CmsSubject;
import com.macro.mall.tiny.service.CmsSubjectService;
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
 * @date 2021/2/19 13:42
 */

@Controller
@CrossOrigin
@RequestMapping("/subject")
@Api(tags = "CmsSubjectController",description = "商品专题管理")
public class CmsSubjectController {

    @Autowired
    private CmsSubjectService cmsSubjectService;


    @ApiOperation("分页查询专题")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubject>> list(@RequestParam(value = "keyword",required = false) String keyword,
                                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                     @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
                                                    ){
       List<CmsSubject> cmsSubjectList =  cmsSubjectService.list(keyword,pageNum,pageSize);
       return CommonResult.success(CommonPage.restPage(cmsSubjectList));

    }

    @ApiOperation("专题列表")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<CmsSubject>> listAll(){
       List<CmsSubject> cmsSubjectList = cmsSubjectService.listAll();
       return CommonResult.success(cmsSubjectList);

    }

}
