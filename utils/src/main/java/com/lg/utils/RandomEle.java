package com.lg.utils;

import java.util.Random;

/**
 * 随机获取元素
 * Created by sclg1 on 2016/11/12.
 */
public class RandomEle {
    private static Random rand = new Random(47);

    /**
     * 随机返回一个枚举类型
     * @param ec
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }

    /**
     * 从数组中随机返回一个元素
     * @param values
     * @param <T>
     * @return
     */
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
