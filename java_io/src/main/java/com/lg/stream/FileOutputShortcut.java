package com.lg.stream;

import com.lg.utils.Directory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 文件读写快捷方法
 * Created by liuguo on 2016/10/21.
 */
public class FileOutputShortcut {

    public static void main(String[] args) throws IOException {
        String outfile = "FileOutputShortcut.out";
        String path = Directory.walk(".", "FileOutputShortcut.java").files.get(0).getAbsolutePath();

        BufferedReader in = new BufferedReader(new FileReader(path));

        /**Java SE5 added a helper constructor to PrintWriter so that you don’t have to do all the
         decoration by hand every time you want to create a text file and write to it.*/
        PrintWriter out = new PrintWriter(outfile);
        /**You still get buffering, you just don’t have to do it yourself. Unfortunately, other commonly
         written tasks were not given shortcuts, so typical I/O will still involve a lot of redundant text. Think in java.P669*/
        int lineCount = 0;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ":" + s);
        }
        out.close();

        System.out.println(BufferedInputFile.read(outfile));
    }
}
