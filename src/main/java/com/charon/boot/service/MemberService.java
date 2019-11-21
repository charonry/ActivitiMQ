package com.charon.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {

    @Async //等于重新开启了一个新的线程
    public String addMemberAndEmail(){
        log.info("2");
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            //TODO:handle exception
        }
        log.info("3");
        return "success";
    }
}
