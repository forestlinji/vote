package com.winterice.vote.service.impl;

import com.winterice.vote.mapper.UserMapper;
import com.winterice.vote.pojo.User;
import com.winterice.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;
    @Override
    public User findUserById(String UserId) {
        return userMapper.selectById(UserId);
    }
}
