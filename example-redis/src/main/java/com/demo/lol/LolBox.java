package com.demo.lol;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sclg1 on 2016/11/11.
 */
public class LolBox {

    public static void main(String[] args) throws InterruptedException {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        JedisPool pool = new JedisPool(config,"centos",6379);

        String[] heros = new String[]{"易大师","提莫","盖伦","皇子","疾风剑豪","金克丝","狐狸","猴子","奥巴马"};

        String key = "lol:heros";
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0;i<10;i++){
            HeroPlayer player = new HeroPlayer(heros,pool.getResource(),key);
            HeroViewer viewer = new HeroViewer(pool.getResource(),key);
            executor.execute(player);
            executor.execute(viewer);
        }

        /*Thread t1 = new Thread(player);

        Thread t2 = new Thread(viewer);

        t1.start();
        t2.start();*/
    }
}
