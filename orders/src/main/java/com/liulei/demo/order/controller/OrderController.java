package com.liulei.demo.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulei.demo.order.entity.Orders;
import com.liulei.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    @GetMapping("/order")
    public Orders getOrder(@RequestParam("id")final Long id) {
        return orderService.getById(id);
    }

    /**
     * 添加订单
     * @param orders
     * @return
     */
    @PostMapping("/order")
    @Transactional
    public Long addOrder(@RequestBody final Orders orders) {
        orders.setCreateTime(new Date());
        return orderService.add(orders);
    }

    /**
     * 删除订单
     * @param id
     */
    @DeleteMapping("/order/{id}")
    @Transactional
    public void deleteOrder(@PathVariable("id")final Long id){
        orderService.removeById(id);
    }

    /**
     * 修改订单
     * @param id
     * @param orders
     * @return
     */
    @PutMapping("/order/{id}")
    @Transactional
    public Orders updateOrder(@PathVariable("id")final Long id, @RequestBody final Orders orders) {
        orders.setId(id);
        orders.setModifyTime(new Date());
        orderService.updateById(orders);
        return orders;
    }

    /**
     * 获取列表
     * @return
     */
    @GetMapping("/orders")
    public List<Orders> getOrderList() {
        return orderService.getBaseMapper().selectList(new QueryWrapper<Orders>().orderByDesc("create_time"));
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param orders
     * @return
     */
    @GetMapping("/order/page")
    public Object getOrderByPage(@RequestParam("pageNum")Integer pageNum,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestBody @Nullable Orders orders) {
        return orderService.selectByPage(pageNum,pageSize, orders);
    }

    @GetMapping("/order/userId")
    public List<Orders> getOrdersByUserId(@RequestParam("userId") Long userId) {
        return orderService.getBaseMapper().selectList(new QueryWrapper<Orders>().eq("user_id",userId));
    }
}
