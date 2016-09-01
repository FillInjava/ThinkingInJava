package com.java8.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liuguo on 2016/8/31.
 */
public class StreamExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "ab", "cde", "ab", "xs", "java", "web", "program"));

        System.out.println("*******To set********");
        list.stream().collect(Collectors.toSet()).forEach(m -> System.out.println(m));

        System.out.println("*******Use map********");
        list.stream().map(m -> m + "zzz").forEach(n -> System.out.println(n));

        System.out.println("*******Use filter********");
        list.stream().filter(m -> m.length() > 2).collect(Collectors.toList()).forEach(m -> System.out.println(m));

        System.out.println("*******Use count********");
        long count = list.stream().filter(m -> m.length() > 2).count();
        System.out.println("长度大于2:" + count);
    }
}
