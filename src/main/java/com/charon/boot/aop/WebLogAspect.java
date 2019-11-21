package com.charon.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Aspect
public class WebLogAspect {

    private static final Logger logger= LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.charon.boot.controller.*.*(..))")
    public void webLogw(){

    }

    @Before("webLogw()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes= (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //记录下请求内容
        logger.info("URL:"+request.getRequestURL().toString());
        logger.info("HTTP_METHOD:"+request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name=(String) parameterNames.nextElement();
            logger.info("name:{},value:{}",name,request.getParameter(name));
        }
    }

    @AfterReturning(returning = "ret",pointcut = "webLogw()")
    public void doAfterRunning(Object ret){
        //处理完请求，记录请求内容
        logger.info("RESPONSE:"+ret);
    }
}
