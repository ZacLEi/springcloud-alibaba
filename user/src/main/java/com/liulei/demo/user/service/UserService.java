package com.liulei.demo.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liulei.demo.user.entity.User;
import com.liulei.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;

    public Long add(User user) {
        userMapper.insert(user);
        return user.getId();
    }
}
