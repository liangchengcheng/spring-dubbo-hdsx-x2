package com.hdsx.dubbo.order.api;

import com.hdsx.dubbo.common.framework.vo.CommonResult;
import com.hdsx.dubbo.common.framework.vo.Result;
import com.hdsx.dubbo.order.api.bean.OrderBean;
import com.hdsx.dubbo.order.api.bean.OrderQueryBean;

import java.util.List;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月16日12:47:55
 * 订单 service
 */
public interface OrderService {

    /**
     * 查询订单的列表
     */
    Result getOrderList(OrderQueryBean orderQueryBean);

    Result getOrderById(String id);

    /**
     * 添加用户
     */
    Result addOrder(OrderBean orderBean);

    /**
     * 修改用户
     */
    Result editOrder(OrderBean orderBean);

    /**
     * 批量编辑订单状态
     */
    Result editOrderState(List<OrderBean> orderBean);

    /**
     * 取消订单
     */
    Result cancelOrderById(String id);

    /**
     * 查询超过发货了且，且updatetime距离现在10天
     */
    Result getOrderListFor7Days(OrderQueryBean orderQueryBean);
}
