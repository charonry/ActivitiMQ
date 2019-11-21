package com.charon.boot.dataSource.source2.service;

import com.charon.boot.dataSource.source2.mapper.UserMapper2;
import com.charon.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServer2 {

    @Autowired
    private UserMapper2 userMapper2;

    public List<User> queryUserList(){
        return userMapper2.queryUserList();
    }

    public int insertUser(String username,String password,String name){
        int result = userMapper2.insert(username, password, name);
        return  result;
    }
}
