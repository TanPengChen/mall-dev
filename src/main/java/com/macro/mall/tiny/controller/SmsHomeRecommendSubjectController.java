package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsHomeRecommendSubject;
import com.macro.mall.tiny.service.SmsHomeRecommendSubjectService;
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
 * @date 2021/2/19 11:10
 */

@Controller
@Api(tags = "SmsHomeRecommendSubjectController",description = "首页专题推荐管理")
@RequestMapping("/home/recommendSubject")
@CrossOrigin
public class SmsHomeRecommendSubjectController {

    @Autowired
    private SmsHomeRecommendSubjectService smsHomeRecommendSubjectService;


    @ApiOperation("分页查询推荐")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsHomeRecommendSubject>> list(@RequestParam(value = "subjectName",required = false) String subjectName,
                                                                  @RequestParam(value = "recommendStatus",required = false) Integer recommendStatus,
                                                                  @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                                                  @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum
                                                                  ){
        List<SmsHomeRecommendSubject> smsHomeRecommendSubjectList = smsHomeRecommendSubjectService.list(subjectName,recommendStatus,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(smsHomeRecommendSubjectList));

    }
}
