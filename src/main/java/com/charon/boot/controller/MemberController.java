package com.charon.boot.controller;

import com.charon.boot.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/addMemberAndEmail")
    public String addMemberAndEmail(){
        log.info("1");
        String result = memberService.addMemberAndEmail();
        log.info("4");
        return "result"+result;
    }
}
