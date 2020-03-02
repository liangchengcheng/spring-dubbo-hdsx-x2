package com.hdsx.dubbo.order.job;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdsx.dubbo.common.framework.vo.Result;
import com.hdsx.dubbo.order.api.OrderService;
import com.hdsx.dubbo.order.api.bean.OrderBean;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * 梁铖城 - 移动开发部
 * 2020年02月16日19:17:44
 * 超时以后自动 确认订单完成
 * 暂不开启
 */

//@Component
//@JobHandler("automaticCommentJob")
public class AutomaticCommentJob extends IJobHandler {

    @Autowired
    private OrderService orderService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        JobMethod();
        return null;
    }

    private void JobMethod() {
        Result orderListFor7Days = orderService.getOrderListFor7Days(null);
        if (orderListFor7Days.getCode() == 1) {
            ObjectMapper mapper = new ObjectMapper();
            List<OrderBean> oldUser = mapper.convertValue(orderListFor7Days.getData(), new TypeReference<List<OrderBean>>() {});
            if (oldUser != null && oldUser.size() > 0) {
                for (OrderBean orderBean : oldUser) {
                    // 设置为完成的状态
                    orderBean.setOrderstate(5);

                }
                orderService.editOrderState(oldUser);
            }
        }
    }
}
