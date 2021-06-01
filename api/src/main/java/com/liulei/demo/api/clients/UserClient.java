package com.liulei.demo.api.clients;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.liulei.demo.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user")
public interface UserClient {
    @GetMapping("/user")
    User getUser(@RequestParam("id") final Long id);

    @GetMapping("/user/name")
    User getUserByName(@RequestParam("username") String username);

    @PostMapping("/user")
    Long addUser(@RequestBody final User user);

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable("id") final Long id);

    @PutMapping("/user/{id}")
    User updateUser(@PathVariable("id") final Long id, @RequestBody final User user);

    @GetMapping("/users")
    List<User> getUserList();

    @GetMapping("/user/page")
    Object getUserByPage(@RequestParam("pageNum") Integer pageNum,
                         @RequestParam("pageSize") Integer pageSize,
                         @RequestBody @Nullable User user);
}
