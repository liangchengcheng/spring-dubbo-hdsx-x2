package com.hdsx.dubbo.order.application.controller;

import com.hdsx.dubbo.common.framework.util.HttpUtil;
import com.hdsx.dubbo.common.framework.util.ServiceExceptionUtil;
import com.hdsx.dubbo.common.framework.vo.CommonResult;
import com.hdsx.dubbo.common.framework.vo.Result;
import com.hdsx.dubbo.common.framework.vo.ResultCode;
import com.hdsx.dubbo.common.framework.vo.ResultUtil;
import com.hdsx.dubbo.order.api.OrderService;
import com.hdsx.dubbo.order.api.bean.OrderBean;
import com.hdsx.dubbo.order.api.bean.OrderQueryBean;
import com.hdsx.dubbo.product.api.bean.ProductNumBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.hdsx.dubbo.common.framework.vo.CommonResult.success;

/**
 *
 * 订单API
 */
@Slf4j
@RestController
@RequestMapping("order")
@Api(description = "用户订单")
public class OrderController {

    @Reference
    private OrderService orderService;

    @ApiOperation(value = "获取订单的列表", httpMethod = "POST", produces = "application/json", notes = "获取订单的列表")
    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    public Result getOrderList(@RequestBody OrderQueryBean orderQueryBean) {
        try {
            return orderService.getOrderList(orderQueryBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.UPDATE_FAIL);
        }
    }

    @ApiOperation(value = "添加订单信息", httpMethod = "POST", produces = "application/json", notes = "添加订单信息")
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public Result addOrder(@RequestBody OrderBean orderBean) {
        try {
            return orderService.addOrder(orderBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.UPDATE_FAIL);
        }
    }

    @ApiImplicitParam(paramType = "query", name = "id", dataType = "String", required = true, value = "订单id")
    @ApiOperation(value = "通过ID查询订单详情", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getOrderById",method = RequestMethod.GET,produces = "application/json")
    public Result getOrderById(@RequestParam String id){
        try{
            return orderService.getOrderById(id);
        } catch (Exception e){
            log.error("服务器异常{}",e.getMessage(),e);
            return ResultUtil.error(ResultCode.QUERY_FAIL);
        }
    }

}
