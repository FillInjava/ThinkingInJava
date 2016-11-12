package com.lg.enums;

import com.lg.utils.RandomEle;

/**
 * Created by sclg1 on 2016/11/12.
 */
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(RandomEle.random(Activity.class));
        }
    }
}

enum Activity{
    SITING,LYING,STANDING,HOPPING,RUNNING,DODGING,JUMPING,FALLING,FLYING
}
