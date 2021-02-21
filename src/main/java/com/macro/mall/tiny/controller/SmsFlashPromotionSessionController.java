package com.macro.mall.tiny.controller;


import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SmsFlashPromotionSessionDetail;
import com.macro.mall.tiny.service.SmsFlashPromotionSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/flashSession")
@Api(tags = "SmsFlashPromotionSessionController",description = "限时购场次管理")
public class SmsFlashPromotionSessionController {

    @Autowired
    private SmsFlashPromotionSessionService smsFlashPromotionSessionService;


    @ApiOperation("设置商品")
    @RequestMapping(value = "/selectList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsFlashPromotionSessionDetail>> selectList(Long flashPromotionId){
    List<SmsFlashPromotionSessionDetail> smsFlashPromotionSessionDetails = smsFlashPromotionSessionService.selectList(flashPromotionId);
    return CommonResult.success(smsFlashPromotionSessionDetails);
    }


}
