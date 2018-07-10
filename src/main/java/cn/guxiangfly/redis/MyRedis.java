package cn.guxiangfly.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * MyRedis
 *
 * @author guxiang
 * @date 2017/11/27
 */
public class MyRedis {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");

        System.out.println(jedis.get("k3"));

        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
    }
}
