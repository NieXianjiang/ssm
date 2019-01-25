package com.nxj.service.impl;

import com.nxj.dao.UserMapper;
import com.nxj.entity.User;
import com.nxj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
