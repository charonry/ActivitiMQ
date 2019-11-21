package com.charon.boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.charon.boot.mapper.UserMapper;
import com.charon.boot.model.Reader;
import com.charon.boot.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void  testString() throws JsonProcessingException {
        //从redis中获取数据，数据格式是json
        String userJson =  redisTemplate.boundValueOps("name").get();
        //判断redis是否含有这个数据
        if(StringUtils.isBlank(userJson)){
            //不存在就从数据库中查询
            List<User> lists = userMapper.queryUserList();
            //将查出的数据放入到redis中
            //向list集合转化为json格式，使用jackson转化
            ObjectMapper objectMapper=new ObjectMapper();
            userJson=objectMapper.writeValueAsString(lists);
            redisTemplate.boundValueOps("user").set(userJson);
            System.out.println("=======从数据库中获取的数据=======");
        }else {
            System.out.println("=======从redis缓存中获取数据=======");
        }
        System.out.println(userJson);
    }

    @Test
    public void mapRedis(){
        Reader sysUser=new Reader();
        sysUser.setName("sysUser");
        sysUser.setAge(23);
        Reader sunny=new Reader();
        sunny.setName("sunny");
        sunny.setAge(18);
        List<Reader> list=new ArrayList();
        list.add(sysUser);
        list.add(sunny);
        Map<String,Object> map=new HashMap();
        //redis中的key
        map.put("reader", JSON.toJSONString(list));
        //redis中value数据中的key
        redisTemplate.opsForHash().putAll("reader",map);
    }


    @Test
    public void  testGetHash()  {
        //从redis中获取数据，数据格式是object
        Object readerList = redisTemplate.opsForHash().get("reader", "reader");
        //转换为string类型
        String jsonString = String.valueOf(readerList);
        //转为list<T>
        List<Reader> list = JSONArray.parseArray(jsonString,Reader.class);
        Iterator<Reader> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
