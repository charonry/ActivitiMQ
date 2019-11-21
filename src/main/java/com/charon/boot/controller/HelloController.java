package com.charon.boot.controller;

import com.charon.boot.model.Article;
import com.charon.boot.model.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class HelloController {

    //private static final Logger log= LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    @ResponseBody
    public Article hello() {
        Article article1=Article.builder().id(5L).author("admin").build();
        log.info("测试一下"+article1);
        return article1;
    }

    @RequestMapping("/test1")
    public String testThymeleaf(ModelMap map){
        List<Reader> lists=new ArrayList<>();
        lists.add(new Reader(1,"张三",12));
        lists.add(new Reader(2,"李四",13));
        map.put("readers",lists);
        return "test01";
    }
}