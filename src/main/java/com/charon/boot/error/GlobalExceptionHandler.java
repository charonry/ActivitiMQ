package com.charon.boot.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获
 */
@ControllerAdvice(basePackages = "com.charon.boot.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map errorResult(){
        Map<String,Object> errorResultMap=new HashMap<>();
        errorResultMap.put("errorCode","500");
        errorResultMap.put("errorMsg","全局捕获异常系统错误");
        return errorResultMap;
    }
}
