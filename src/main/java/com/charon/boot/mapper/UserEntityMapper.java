package com.charon.boot.mapper;

import com.charon.boot.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserEntityMapper {
    UserEntity findByUserName(@Param("username") String userName);
    UserEntity findByUserNameAndPassWord(@Param("username") String userName,@Param("password") String passWord);
    void saveUserEntity(UserEntity userEntity);
}
