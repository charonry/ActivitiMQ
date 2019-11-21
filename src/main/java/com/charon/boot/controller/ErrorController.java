package com.charon.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局捕获异常
 */
@RestController
public class ErrorController {
    private  static final Logger logger= LoggerFactory.getLogger(ErrorController.class);
    @RequestMapping("/errorMsg")
    public String getError(int i){
        logger.info("springBoot继承log4j成功");
        int j=1/i;
        return "success";
    }
}
