package com.lg.enums;

import static com.lg.enums.Spiciness.*;

/**
 * 静态导入enum类型
 * Created by sclg1 on 2016/11/12.
 */
public class Burrito {
    private Spiciness degree;
    Burrito(Spiciness degree){
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Burrito is "+degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(MILD));
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(HOT));
    }
}
