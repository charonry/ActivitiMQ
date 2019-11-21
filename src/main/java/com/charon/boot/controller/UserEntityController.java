package com.charon.boot.controller;

import com.charon.boot.model.UserEntity;
import com.charon.boot.service.UserEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/userEntity")
public class UserEntityController {
    @Autowired
    private UserEntityService userEntityService;

    UserEntity userEntity=new UserEntity();

    /**
     * 登陆成功返回的页面，判断是否有session
     * @param httpSession
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpSession httpSession) {
        if(httpSession.getAttribute("userLogin")!=null){
            return "index";
        }else {
            return "login";
        }
    }

    /**
     * 注册的页面映射
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * 登录页面的映射
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        String str="";
        String username = userEntity.getUsername();
        if(username!=null) {
            str="index";
        }else {
            str="login";
        }
        return str;
    }

    /**
     * 登录的后台页面并且添加session
     * @param request
     * @param session
     * @param modelMap
     * @return
     */
    @RequestMapping("/uLogin")
    public String login(HttpServletRequest request, HttpSession session, ModelMap modelMap){
        log.info("开始进行登录验证");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        userEntity = userEntityService.findByUserNameAndPassWord(username,password);
        String str="";
        if(userEntity!=null){
            session.setAttribute("userLogin",userEntity);
            modelMap.put("login",userEntity);
            str="index";
        }else {
            str="login";

        }
        return str;
    }

    /**
     * 注册的后台校验
     * @param request
     * @return
     */
    @RequestMapping("/uRegister")
    public String register(HttpServletRequest request){
        log.info("开始进行注册验证");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
        String tel=request.getParameter("tel");
        String realname=request.getParameter("realname");
        String str="";
        if(password.equals(password2)) {
            UserEntity userEntity = userEntityService.findByUserName(username);
            if(userEntity==null) {
                UserEntity user=new UserEntity();
                user.setUsername(username);
                user.setPassword(password);
                user.setRelname(realname);
                user.setTel(tel);
                userEntityService.saveUserEntity(user);
                str="login";
            }else {
                str="register";
            }
        }else {
            str="register";
        }
        return str;
    }

}
