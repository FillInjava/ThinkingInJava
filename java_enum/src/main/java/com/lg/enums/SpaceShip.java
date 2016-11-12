package com.lg.enums;

/**
 * 修改为首字母大写的形式
 * Created by sclg1 on 2016/11/12.
 */
public enum SpaceShip {
    SCOUT,CARGO,TRANSPORT,CURISER,BATTLESHIP,MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0)+lower;
    }

    public static void main(String[] args) {
        for(SpaceShip ship : SpaceShip.values()){
            System.out.println(ship.name()+" "+ship);
        }
    }
}
