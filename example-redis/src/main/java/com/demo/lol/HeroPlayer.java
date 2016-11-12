package com.demo.lol;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * Created by sclg1 on 2016/11/11.
 */
public class HeroPlayer implements Runnable {

    private String[] heros;
    private Jedis jedis;
    private String key;

    public HeroPlayer(String[] heros, Jedis jedis, String key){
        this.heros = heros;
        this.jedis = jedis;
        this.key = key;
    }

    public void run() {
        while (true){
            int index = new Random().nextInt(heros.length);

            jedis.zincrby(key,1,heros[index]);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(heros[index]+"英雄上场了");
            System.out.println("**************************");
        }
    }
}
