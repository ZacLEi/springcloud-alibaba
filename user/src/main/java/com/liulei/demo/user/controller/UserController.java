package com.liulei.demo.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liulei.demo.user.entity.User;
import com.liulei.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/user")
    public User getUser(@RequestParam("id")final Long id) {
        return userService.getById(id);
    }

    @GetMapping("/user/name")
    public User getUserByName(@RequestParam("username")String username) {
        return userService.getOne(new QueryWrapper<User>().eq("name", username));
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/user")
    @Transactional
    public Long addUser(@RequestBody final User user) {
        return userService.add(user);
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("/user/{id}")
    @Transactional
    public void deleteUser(@PathVariable("id")final Long id){
        userService.removeById(id);
    }

    /**
     * 修改用户
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/user/{id}")
    @Transactional
    public User updateUser(@PathVariable("id")final Long id,@RequestBody final User user) {
        user.setId(id);
        userService.updateById(user);
        return user;
    }

    /**
     * 获取列表
     * @return
     */
    @GetMapping("/users")
    public List<User> getUserList() {
        return userService.getBaseMapper().selectList(new QueryWrapper<User>());
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param user
     * @return
     */
    @GetMapping("/user/page")
    public Object getUserByPage(@RequestParam("pageNum")Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize,
                                    @RequestBody @Nullable User user) {
        return userService.selectByPage(pageNum,pageSize,user);
    }
}
