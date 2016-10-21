package com.lg.stream;

import com.lg.utils.Directory;

import java.io.*;

/**
 * 文件读写基本方法
 * Created by liuguo on 2016/10/21.
 */
public class BasicFileOutput {
    public static void main(String[] args) throws IOException {
        String outfile = "BasicFileOutput.out";
        String path = Directory.walk(".", "BasicFileOutput.java").files.get(0).getAbsolutePath();

        BufferedReader in = new BufferedReader(new FileReader(path));
        //LineNumberReader in = new LineNumberReader(new FileReader(path));//保持行号很容易,不需要使用LineNumberReader
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outfile)));
        String s;
        int lineCount = 1;
        while ((s = in.readLine()) != null) { //当stream用完时,会返回null
            out.println(lineCount++ + ": " + s);
            //out.println(in.getLineNumber()+":"+s);
        }

        /**You’ll see an explicit
         close( ) for out, because if you don’t call close( ) for all your output files, you might
         discover that the buffers don’t get flushed, so the file will be incomplete--Think in java.P668*/
        out.close();

        System.out.println(BufferedInputFile.read(outfile));

    }
}
