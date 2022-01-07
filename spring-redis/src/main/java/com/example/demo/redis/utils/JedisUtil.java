package com.example.demo.redis.utils;

import redis.clients.jedis.Jedis;

/**
 * @Author mubi
 * @Date 2020/4/14 23:30
 */
public class JedisUtil {
    public static Jedis getJedis() {
        Jedis jedis = new Jedis("127.0.0.1");
        return jedis;
    }

    public static Jedis getJedis(String host, int port) {
        Jedis jedis = new Jedis(host, port);
        return jedis;
    }
}
