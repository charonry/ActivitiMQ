package com.charon.boot.service;

import com.charon.boot.mapper.UserEntityMapper;
import com.charon.boot.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {
    @Autowired
    private UserEntityMapper userEntityMapper;

    public UserEntity findByUserName(String username){
        UserEntity userEntity = userEntityMapper.findByUserName(username);
        return  userEntity;
    }

    public UserEntity findByUserNameAndPassWord(String username,String password){
        UserEntity userEntity = userEntityMapper.findByUserNameAndPassWord(username,password);
        return  userEntity;
    }

    public void saveUserEntity(UserEntity userEntity){
        userEntityMapper.saveUserEntity(userEntity);
    }
}
