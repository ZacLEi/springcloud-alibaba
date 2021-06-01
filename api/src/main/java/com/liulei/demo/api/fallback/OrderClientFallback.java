package com.liulei.demo.api.fallback;

import com.liulei.demo.api.clients.OrderClient;
import com.liulei.demo.api.entity.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class OrderClientFallback implements OrderClient {
    @Override
    public Orders getOrder(Long id) {
        log.error("getOrder 触发熔断！");
        return null;
    }

    @Override
    public Long addOrder(Orders orders) {
        log.error("addOrder 触发熔断！");
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        log.error("deleteOrder 触发熔断！");
    }

    @Override
    public Orders updateOrder(Long id, Orders orders) {
        log.error("updateOrder 触发熔断！");
        return null;
    }

    @Override
    public List<Orders> getOrderList() {
        log.error("getOrderList 触发熔断！");
        return null;
    }

    @Override
    public Object getOrderByPage(Integer pageNum, Integer pageSize, Orders orders) {
        log.error("getOrderByPage 触发熔断！");
        return null;
    }

    @Override
    public List<Orders> getOrdersByUserId(Long userId) {
        log.error("getOrdersByUserId 触发熔断！");
        return null;
    }
}
