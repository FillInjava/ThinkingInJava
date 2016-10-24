package com.lg.stream;

import java.io.PrintWriter;

/**
 * 将System.out包装称PrintWriter
 * Created by sclg1 on 2016/10/22.
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("hahha");
    }
}
