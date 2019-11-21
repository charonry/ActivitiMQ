package com.charon.boot.service;

import com.charon.boot.mapper.UserMapper;
import com.charon.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServer {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }
}
