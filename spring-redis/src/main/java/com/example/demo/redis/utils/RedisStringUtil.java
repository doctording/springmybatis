package com.example.demo.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author mubi
 * @Date 2020/4/14 23:20
 */
public final class RedisStringUtil {

    public static String getRedisKey(String key){
        Jedis jedis = JedisUtil.getJedis();
        return jedis.get(key);
    }

    public static Boolean existRedisKey(String key){
        Jedis jedis = JedisUtil.getJedis();
        return jedis.exists(key);
    }

    public static String setRedisKey(String key, String value){
        Jedis jedis = JedisUtil.getJedis();
        return jedis.set(key,value);
    }

//    public static String setRedisKey(String key, String value, Integer sec){
//        Jedis jedis = JedisUtil.getJedis();
//        return jedis.set(key, value, "NX", "EX", sec);
//    }

}
