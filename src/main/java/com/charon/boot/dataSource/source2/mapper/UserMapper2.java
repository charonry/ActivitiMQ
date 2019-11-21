package com.charon.boot.dataSource.source2.mapper;

import com.charon.boot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper2 {
    public List<User> queryUserList();

    @Insert("INSERT into user(username,password,name) values(#{username},#{password},#{name})")
    int insert(@Param("username") String username, @Param("password")String password,
               @Param("name")String name);
}
