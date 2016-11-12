package com.lg.enums;

/**
 * Created by sclg1 on 2016/11/12.
 */
public class TrafficLight {
    Signal color = Signal.RED;

    public void change(){
        switch (color){
            case RED:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.RED;
                break;
        }
    }
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();

        for(int i = 0;i<7;i++){
            System.out.println(light);
            light.change();
        }
    }

    @Override
    public String toString() {return "The light is " +color;

    }
}

enum Signal{
     RED,YELLOW,GREEN
}
