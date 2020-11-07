package com.winterice.vote.service.impl;

import com.winterice.vote.mapper.RoleMapper;
import com.winterice.vote.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    public  RoleMapper roleMapper;
    @Override
    public List<String> getRoleListById(String userId) {
        return roleMapper.getRoleListById(userId);
    }
}
