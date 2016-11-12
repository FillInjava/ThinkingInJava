package com.lg.enums;

/**
 * Created by sclg1 on 2016/11/12.
 */

public class EnumClass {
    public static void main(String[] args) {
        for(Shrubbery shrubbery : Shrubbery.values()){
            System.out.println(shrubbery + " ordinal: "+shrubbery.ordinal());
            System.out.println(shrubbery.compareTo(shrubbery.CRAWLING));
            System.out.println(shrubbery.equals(Shrubbery.CRAWLING));
            System.out.println(shrubbery == shrubbery.CRAWLING);
            System.out.println(shrubbery.getDeclaringClass());
            System.out.println(shrubbery.name());
            System.out.println("*********************");
        }

        for(String name : "GROUND CRAWLING HANGING".split(" ")){
            Shrubbery s = Shrubbery.valueOf(name);
            //com.lg.enums.Shrubbery.valueOf(com.lg.enums.Shrubbery.class,name);
            System.out.println(s);
        }
    }
}
enum Shrubbery{
    GROUND,CRAWLING,HANGING
}
