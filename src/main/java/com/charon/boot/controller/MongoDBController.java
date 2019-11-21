package com.charon.boot.controller;

import com.charon.boot.mapper.MongoDao;
import com.charon.boot.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//统一用getmapping只是方便测试，还是要遵守rest风格
@RestController
public class MongoDBController {

    @Autowired
    private MongoDao mongoDao;

    @GetMapping(value="/saveDB")
    public void saveTest() {
        Reader reader=new Reader();
        reader.setId(11);
        reader.setAge(33);
        reader.setName("ceshi");
        mongoDao.svae(reader);
    }


    @GetMapping(value="/findDB")
    public Reader findByName(){
        Reader reader= mongoDao.findByName("ceshi");
        System.out.println("reader is "+reader);
        return reader;
    }

    @GetMapping(value="/updateDB")
    public void update(){
        Reader reader=new Reader();
        reader.setId(11);
        reader.setAge(44);
        reader.setName("ceshi2");
        mongoDao.updateReader(reader);
    }

    @GetMapping(value="/deletDB")
    public void deleteTestById(){
        mongoDao.deleteById(11);
    }

}
