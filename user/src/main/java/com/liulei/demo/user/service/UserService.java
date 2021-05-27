package com.liulei.demo.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liulei.demo.user.entity.User;
import com.liulei.demo.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;

    public Long add(User user) {
        userMapper.insert(user);
        return user.getId();
    }

    public List<User> selectByPage(Integer pageNum, Integer pageSize,@Nullable User user) {
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (user!= null) {
            if (user.getAge()!= null){
                wrapper.eq("age",user.getAge());
            }else if (user.getGender()!= null ){
                wrapper.eq("gender",user.getGender());
            }else if (user.getName()!= null ){
                wrapper.like("name","%"+user.getName()+"%");
            }
        }

        return userMapper.selectPage(page, wrapper).getRecords();
    }
}
