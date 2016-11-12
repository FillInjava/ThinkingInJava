package com.demo.lol;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * Created by sclg1 on 2016/11/11.
 */
public class HeroViewer implements Runnable{

    private String key;
    private Jedis jedis;
    HeroViewer(Jedis jedis,String key){
        this.jedis = jedis;
        this.key = key;
    }
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Set<Tuple> set = jedis.zrevrangeWithScores(key,0,4);

            for(Tuple tuple : set){
                System.out.println(tuple.getElement()+":"+tuple.getScore());
            }
            System.out.println("************************");

        }
    }
}
