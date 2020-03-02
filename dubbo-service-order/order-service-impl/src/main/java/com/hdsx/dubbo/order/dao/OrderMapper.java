package com.hdsx.dubbo.order.dao;

import com.hdsx.dubbo.order.api.bean.OrderBean;
import com.hdsx.dubbo.order.api.bean.OrderQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单 mapper
 */
public interface OrderMapper {
    /**
     * 查询订单的列表
     */
    List<OrderBean> getOrderList(OrderQueryBean orderQueryBean);

    int getOrderListNum(OrderQueryBean orderQueryBean);

    OrderBean getOrderById(String id);

    /**
     * 添加用户
     */
    int addOrder(OrderBean orderBean);

    /**
     * 修改用户
     */
    int editOrder(OrderBean orderBean);

    int editOrderState(List<OrderBean> orderBean);

    /**
     * 取消订单
     */
    int cancelOrderById(String id);

    /**
     * 查询超过发货了且，且updatetime距离现在10天
     */
    List<OrderBean> getOrderListFor7Days(OrderQueryBean orderQueryBean);
}