package com.charon.boot.dataSource.source1.service;

import com.charon.boot.dataSource.source1.mapper.UserMapper1;
import com.charon.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServer1 {

    @Autowired
    private UserMapper1 userMapper1;

    public List<User> queryUserList(){
        return userMapper1.queryUserList();
    }

    public int insertUser(String username,String password,String name){
        int result = userMapper1.insert(username, password, name);
        return  result;
    }
}
