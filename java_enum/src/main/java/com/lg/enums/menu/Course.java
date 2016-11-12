package com.lg.enums.menu;

import com.lg.utils.RandomEle;

/**
 * Created by sclg1 on 2016/11/12.
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] foods;

    Course(Class<? extends Food> kind) {
        foods = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return RandomEle.random(foods);
    }
}
