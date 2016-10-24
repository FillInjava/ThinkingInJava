package com.lg.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标准输入输出流
 * Created by sclg1 on 2016/10/22.
 */
public class Echo {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while ((s = in.readLine()) != null){
            System.out.println(s);
        }
    }
}
