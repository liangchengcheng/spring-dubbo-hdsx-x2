package com.hdsx.dubbo.product.controller;

import com.hdsx.dubbo.common.framework.vo.CommonResult;
import com.hdsx.dubbo.common.framework.vo.Result;
import com.hdsx.dubbo.common.framework.vo.ResultCode;
import com.hdsx.dubbo.common.framework.vo.ResultUtil;
import com.hdsx.dubbo.product.api.ProductService;
import com.hdsx.dubbo.product.api.bean.ProductBean;
import com.hdsx.dubbo.product.api.bean.ProductNumBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import static com.hdsx.dubbo.common.framework.vo.CommonResult.success;

@Slf4j
@RestController
@RequestMapping("/product")
@Api("商品基本信息服务类")
public class ProductController {

    @Reference
    private ProductService productService;

    @ApiOperation(value = "新增或更新商品信息", httpMethod = "POST", produces = "application/json", notes = "新增或更新商品信息")
    @RequestMapping(value = "/InsertOrUpdateProduct", method = RequestMethod.POST)
    public Result InsertOrUpdateProduct(@RequestBody ProductBean productBean) {
        try {
            return productService.InsertOrUpdateProduct(productBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.UPDATE_FAIL);
        }
    }

    @ApiOperation(value = "减少商品库存信息", httpMethod = "POST", produces = "application/json", notes = "减少商品库存信息")
    @RequestMapping(value = "/UpdateProductNumBean", method = RequestMethod.POST)
    public Result UpdateProductNumBean(@RequestBody ProductNumBean productNumBean) {
        try {
            return productService.UpdateProductNumBean(productNumBean);
        } catch (Exception e) {
            log.error("系统异常:{}", e.getMessage(), e);
            return ResultUtil.error(ResultCode.UPDATE_FAIL);
        }
    }

    @ApiImplicitParam(paramType = "query", name = "id", dataType = "String", required = true, value = "商品id")
    @ApiOperation(value = "通过ID查询商品详情", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getProductById",method = RequestMethod.GET,produces = "application/json")
    public Result getProductById(@RequestParam String id){
        try{
            return productService.getProductById(id);
        } catch (Exception e){
            log.error("服务器异常{}",e.getMessage(),e);
            return ResultUtil.error(ResultCode.QUERY_FAIL);
        }
    }

}
