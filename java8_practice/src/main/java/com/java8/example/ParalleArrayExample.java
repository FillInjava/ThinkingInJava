package com.java8.example;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by liuguo on 2016/9/1.
 */
public class ParalleArrayExample {

    public static void main(String[] args) {
        long[] arryOfLong = new long[20000];
        Arrays.parallelSetAll(arryOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(arryOfLong).limit(10).forEach(n -> System.out.println("n = [" + n + "]"));

        Arrays.parallelSort(arryOfLong);
        Arrays.stream(arryOfLong).limit(10).forEach(n -> System.out.println("n = [" + n + "]"));
    }
}
