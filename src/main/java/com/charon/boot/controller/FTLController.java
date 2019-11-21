package com.charon.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FTLController {

    @RequestMapping("/ftlIndex")
    public String ftlIndex(Map<String,Object> map){
        map.put("name","charon");
        map.put("age",12);
        map.put("sex",1);
        return "FTLIndex";
    }
}
