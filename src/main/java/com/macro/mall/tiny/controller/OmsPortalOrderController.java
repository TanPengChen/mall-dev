package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.OrderParam;
import com.macro.mall.tiny.mbg.model.OmsOrderDetail;
import com.macro.mall.tiny.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author TANPENG
 * @version 1.0
 * @date 2020/12/26 9:22
 */
@Controller
@RequestMapping("/order")
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@CrossOrigin
public class OmsPortalOrderController {

    @Autowired
    private OmsPortalOrderService portalOrderService;


    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("根据购物车信息生成订单")
    public Object generateOrder(@RequestBody OrderParam orderParam){

        return portalOrderService.generateOrder(orderParam);
    }

    @ApiOperation("按状态分页获取用户订单列表")
    //@ApiImplicitParam(name = "status",value = "订单状态：-1->全部；0->待付款；1->代发货；2->已发货;3->已完成；4->已关闭",
      //                  defaultValue = "-1",allowableValues = "-1,0,1,2,3,4",paramType = "query",dataType = "int")
    @RequestMapping(value = "/list2",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OmsOrderDetail>> list(@RequestParam Integer status ,
                                                         @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                         @RequestParam(required = false,defaultValue = "5") Integer pageSize
                            ){
        CommonPage<OmsOrderDetail> orderPage =  portalOrderService.list(status,pageNum,pageSize);
        return CommonResult.success(orderPage);


    }
}
