package com.java8.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by liuguo on 2016/8/31.
 */
public class Counter {
    public static void main(String[] args) {
        String[] arr = new String[]{"program", "creek", "program", "creek", "java", "web", "program"};

        Arrays.sort(arr, (String m, String n) -> Integer.compare(m.length(), n.length()));
        System.out.println("升序:" + Arrays.toString(arr));

        System.out.println("****************************************");

        Arrays.sort(arr, (m, n) -> {
            if (m.length() > n.length())
                return -1;
            else
                return 1;
        });
        System.out.println("倒序:" + Arrays.toString(arr));

        System.out.println("****************************************");
        Stream<String> stream1 = Stream.of(arr);
        stream1.forEach(m -> System.out.println("遍历:" + m));
        //stream1.forEach(m-> System.out.println("遍历2:"+m)); Exception:stream only visited once

        System.out.println("****************************************");

        Stream<String> stream = Stream.of(arr).parallel();

        Map<String, Long> counter = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(counter.get("program"));
    }
}
