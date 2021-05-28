package com.liulei.demo.order.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liulei.demo.order.entity.Orders;
import com.liulei.demo.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Orders> {
    @Autowired
    private OrderMapper orderMapper;

    public Long add(Orders orders) {
        orderMapper.insert(orders);
        return orders.getId();
    }

    public Object selectByPage(Integer pageNum, Integer pageSize,@Nullable Orders orders) {
        IPage<Orders> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        if (orders != null) {
            if (orders.getItemName()!= null){
                wrapper.eq("item_name", orders.getItemName());
            }else if (orders.getPrice()!= null ){
                wrapper.eq("price", orders.getPrice());
            }else if (orders.getUserId()!= null ){
                wrapper.eq("user_id", orders.getUserId());
            }
        }

        return orderMapper.selectPage(page, wrapper);
    }
}
