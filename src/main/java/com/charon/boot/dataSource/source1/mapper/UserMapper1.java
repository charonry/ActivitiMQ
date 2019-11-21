package com.charon.boot.dataSource.source1.mapper;

import com.charon.boot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper1 {
    public List<User> queryUserList();

    @Insert("INSERT into user(username,password,name) values(#{username},#{password},#{name})")
    int insert(@Param("username") String username, @Param("password")String password,
               @Param("name")String name);
}
