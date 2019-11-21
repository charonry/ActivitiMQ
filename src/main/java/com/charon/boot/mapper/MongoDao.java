package com.charon.boot.mapper;

import com.charon.boot.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class MongoDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存reader类型进入mongodb数据库
     * @param reader
     */
    public void svae(Reader reader){
        mongoTemplate.save(reader);
    }

    /**
     * 根据用户名查询对象
     * @return
     */
    public Reader findByName(String name) {
        Query query=new Query(Criteria.where("name").is(name));
        Reader reader =  mongoTemplate.findOne(query , Reader.class);
        return reader;
    }

    /**
     * 更新对象
     */
    public void updateReader(Reader reader) {
        Query query=new Query(Criteria.where("id").is(reader.getId()));
        Update update= new Update().set("age", reader.getAge()).set("name", reader.getName());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,Reader.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,TestEntity.class);
    }

    /**
     * 删除对象
     * @param id
     */
    public void deleteById(Integer id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Reader.class);
    }

}
