package com.liulei.demo.api.clients;

import com.liulei.demo.order.entity.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order")
public interface OrderClient {
    @GetMapping("/order")
    public Orders getOrder(@RequestParam("id")final Long id);

    @PostMapping("/order")
    public Long addOrder(@RequestBody final Orders orders);

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable("id")final Long id);

    @PutMapping("/order/{id}")
    public Orders updateOrder(@PathVariable("id")final Long id, @RequestBody final Orders orders);

    @GetMapping("/orders")
    public List<Orders> getOrderList();

    @GetMapping("/order/page")
    public Object getOrderByPage(@RequestParam("pageNum")Integer pageNum,
                                 @RequestParam("pageSize") Integer pageSize,
                                 @RequestBody @Nullable Orders orders);

    @GetMapping("/order/userId")
    public List<Orders> getOrdersByUserId(@RequestParam("userId") Long userId);
}
