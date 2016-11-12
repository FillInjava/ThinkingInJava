package com.lg.enums.menu;

/**
 * Created by sclg1 on 2016/11/12.
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for(Course course : Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---------");
        }
    }
}
