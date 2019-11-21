package com.charon.boot.redis;


import com.charon.boot.model.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisConfig {

    @Autowired
    private RedisTemplate redisTemplate;


}
