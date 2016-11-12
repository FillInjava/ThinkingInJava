package com.demo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.*;

/**
 * Created by sclg1 on 2016/11/10.
 */
public class RedisTest{

    @Test
    public void testConnect(){
        Jedis jedis = new Jedis("centos",6379);
        String result = jedis.ping();
        System.out.println(result);
    }
    @Test
    public void testAdd(){
        Jedis jedis = new Jedis("centos",6379);
        jedis.set("haha","你好");
        System.out.println(jedis.get("haha"));

    }
    @Test
    public void testObject() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("aa");
        person.setAge(52);
        person.setSex("女");

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(person);

        Jedis jedis = new Jedis("centos",6379);
        jedis.set("Person".getBytes(),bao.toByteArray());

        /**读出对象*/
        ByteArrayInputStream bis = new ByteArrayInputStream(jedis.get("Person".getBytes()));
        ObjectInputStream ois = new ObjectInputStream(bis);
        Person p = (Person) ois.readObject();

        System.out.println(p.toString());

    }

    @Test
    public void testJSON(){
        Person person = new Person();
        person.setSex("喃");
        person.setAge(22);
        person.setName("addd");

        String jsonStr = JSON.toJSONString(person);

        Jedis jedis = new Jedis("centos",6379);

        jedis.set("person",jsonStr);

        String returnStr = jedis.get("person");
        Person p =  JSON.parseObject(returnStr,Person.class);

        System.out.println(p.toString());
    }
}
