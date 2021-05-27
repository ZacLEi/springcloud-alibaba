package com.liulei.demo.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulei.demo.user.entity.User;
import com.liulei.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUser(@RequestParam("id")final Long id) {
        return userService.getById(id);
    }

    @PostMapping("/user")
    @Transactional
    public Long addUser(@RequestBody final User user) {
        return userService.add(user);
    }

    @DeleteMapping("/user/{id}")
    @Transactional
    public void deleteUser(@PathVariable("id")final Long id){
        userService.removeById(id);
    }

    @PutMapping("/user/{id}")
    @Transactional
    public User updateUser(@PathVariable("id")final Long id,@RequestBody final User user) {
        user.setId(id);
        userService.updateById(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUserList() {
        return userService.getBaseMapper().selectList(new QueryWrapper<User>());
    }
}
