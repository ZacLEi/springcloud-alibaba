package com.liulei.demo.api.clients;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liulei.demo.order.entity.Orders;
import com.liulei.demo.api.fallback.OrderClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order",fallback = OrderClientFallback.class)
public interface OrderClient {
    @GetMapping("/order")
    Orders getOrder(@RequestParam("id") final Long id);

    @PostMapping("/order")
    Long addOrder(@RequestBody final Orders orders);

    @DeleteMapping("/order/{id}")
    void deleteOrder(@PathVariable("id") final Long id);

    @PutMapping("/order/{id}")
    Orders updateOrder(@PathVariable("id") final Long id, @RequestBody final Orders orders);

    @GetMapping("/orders")
    List<Orders> getOrderList();

    @GetMapping("/order/page")
    Object getOrderByPage(@RequestParam("pageNum") Integer pageNum,
                          @RequestParam("pageSize") Integer pageSize,
                          @RequestBody @Nullable Orders orders);

    @GetMapping("/order/userId")
    List<Orders> getOrdersByUserId(@RequestParam("userId") Long userId);
}
