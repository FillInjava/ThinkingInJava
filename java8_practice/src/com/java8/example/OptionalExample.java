package com.java8.example;

import java.util.Optional;

/**
 * Created by liuguo on 2016/8/31.
 */
public class OptionalExample {
    public static void main(String[] args) {
        //创建Optional实例
        Optional<String> name = Optional.of("liuguo");
        //java.lang.NullPointerException
        //Optional<String> someNull = Optional.of(null);
        Optional<String> empty = Optional.ofNullable(null);

        //如果Optional有值则将其返回，否则抛出NoSuchElementException。
        if(name.isPresent()){
            System.out.println("name = [" + name.get() + "]");
        }
        //NoSuchElementException: No value present
        //System.out.println("empty = [" + empty.get() + "]");

        //如果Optional实例有值则为其调用consumer，否则不做处理
        name.ifPresent(value-> System.out.println("The length of value:"+value.length()));
        //orElse
        System.out.println("Use orElse: name = [" + name.orElse("no value") + "]");
        System.out.println("Use orElse: empty = [" + empty.orElse("no value") + "]");
        //orElseGet
        System.out.println("Use orElseGet: name = [" + name.orElseGet(()->"default value") + "]");
        System.out.println("Use orElseGet: empty = [" + empty.orElseGet(()->"default value") + "]");

        try {
            System.out.println("Use orElseThrow: name = [" + name.orElseThrow(ValueAbsentException::new) + "]");
            System.out.println("Use orElseThrow: name = [" + empty.orElseThrow(ValueAbsentException::new) + "]");
        }catch (ValueAbsentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Use map: name = [" + name.map(x->x.toUpperCase()).orElse("no value") + "]");
        System.out.println("Use map: empty = [" + empty.map(x->x.toUpperCase()).orElse("no value") + "]");

        //USE flatMap
        Optional<String> uperName =  name.flatMap(value->Optional.of(value.toUpperCase()));
        System.out.println("uperName = [" + uperName.orElse("default value") + "]");

        //filter
        Optional<String> loginName = name.filter(value->value.length()>5);
        System.out.println("loginName = [" + loginName.orElse("The name is less than 6 characters") + "]");

        Optional<String> anotherName = Optional.of("lg");
        Optional<String> shortName = anotherName.filter(value->value.length()>5);
        System.out.println("shortName = [" + shortName.orElse("The name is less than 6 characters") + "]");


    }
}
