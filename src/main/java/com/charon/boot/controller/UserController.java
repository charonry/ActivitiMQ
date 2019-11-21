package com.charon.boot.controller;

import com.charon.boot.model.User;
import com.charon.boot.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServer userServer;

    @RequestMapping("/query")
    @ResponseBody
    public List<User> queryUserList(){
        return userServer.queryUserList();
    }
}
