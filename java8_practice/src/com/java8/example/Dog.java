package com.java8.example;

/**
 * Created by liuguo on 2016/8/31.
 */
public class Dog {
    String name;
    int height;
    int weight;

    public  Dog(String n,int h,int w){
        this.name = n;
        this.height = h;
        this.weight = w;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return getName() + ": size=" + getHeight() + " weight=" + getWeight()
                + " \n";
    }
}
