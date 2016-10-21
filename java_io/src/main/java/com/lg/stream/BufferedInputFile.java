package com.lg.stream;

import com.lg.utils.Directory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liuguo on 2016/10/21.
 */
public class BufferedInputFile {

    public static String read(String filename) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();

        while ((s = in.readLine()) != null) {
            sb.append(s + "\n");
        }

        in.close();

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String path = Directory.walk(".", "BufferedInputFile.java").files.get(0).getAbsolutePath();
        System.out.println(read(path));
    }
}
