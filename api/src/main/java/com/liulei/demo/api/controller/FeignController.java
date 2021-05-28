package com.liulei.demo.api.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liulei.demo.api.clients.OrderClient;
import com.liulei.demo.api.clients.UserClient;
import com.liulei.demo.order.entity.Orders;
import com.liulei.demo.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FeignController {
    @Autowired
    private OrderClient orderClient;

    @Autowired
    private UserClient userClient;

    @GetMapping("/getUserOrdersByUserName")
    @SentinelResource(value = "/getUserOrdersByUserName",fallback = "getUserOrdersByUserNameFail" )
    public List<Orders> getUserOrdersByUserName(@RequestParam("username") String username) {
        User user = userClient.getUserByName(username);
        return  orderClient.getOrdersByUserId(user.getId());
    }

    public List<Orders> getUserOrdersByUserNameFail(@RequestParam("username") String username) {
        log.error("流量控制成功！");
        return null;
    }

}
