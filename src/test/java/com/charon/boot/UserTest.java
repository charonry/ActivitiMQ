package com.charon.boot;

import com.charon.boot.mapper.JPAUserRepository;
import com.charon.boot.mapper.UserMapper;
import com.charon.boot.model.JPAUser;
import com.charon.boot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JPAUserRepository jpaUserRepository;
    @Test
    public void test(){
        List<User> list= userMapper.queryUserList();
        System.out.println(list);
    }

    @Test
    public void testJPA(){
        List<JPAUser> list= jpaUserRepository.findAll();
        System.out.println(list);
    }
}
