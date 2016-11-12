package com.lg.enums;

/**
 * 枚举加入其他信息
 * Created by sclg1 on 2016/11/12.
 */
public enum OzWitch {
    WEST("The direction is west"),
    EAST("The direction is east"),
    NORTH("The direction is north"),
    SOUTH("The direction is south");

    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        for(OzWitch o : OzWitch.values()){
            System.out.println(o +": "+ o.description);
        }
    }
}
