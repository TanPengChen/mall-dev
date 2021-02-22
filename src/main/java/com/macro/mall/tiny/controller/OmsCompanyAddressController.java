package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.OmsCompanyAddress;
import com.macro.mall.tiny.service.OmsCompanyAddressService;
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
 * @date 2021/2/22 16:43
 */

@Controller
@CrossOrigin
@RequestMapping("/companyAddress")
@Api(tags = "OmsCompanyAddressController",description = "收货地址管理")
public class OmsCompanyAddressController {

    @Autowired
    private OmsCompanyAddressService omsCompanyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<OmsCompanyAddress>> list(){
       List<OmsCompanyAddress> companyAddressList = omsCompanyAddressService.list();
       return CommonResult.success(companyAddressList);
    }
}
