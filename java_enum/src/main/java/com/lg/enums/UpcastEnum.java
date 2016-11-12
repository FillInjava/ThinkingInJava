package com.lg.enums;

/**
 * Created by sclg1 on 2016/11/12.
 */
public class UpcastEnum {

    public static void main(String[] args) {
        Seach[] vals = Seach.values();
        Enum ele = Seach.HITHEN; //向上转型

        for(Enum e : ele.getClass().getEnumConstants()){
            System.out.println(e);
        }
    }



}
enum Seach{
    HITHEN,YON
}
