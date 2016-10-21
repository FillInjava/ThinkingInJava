package com.lg.stream;

import com.lg.utils.Directory;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by liuguo on 2016/10/21.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        String path = Directory.walk(".", "MemoryInput.java").files.get(0).getAbsolutePath();

        StringReader reader = new StringReader(BufferedInputFile.read(path));
        int c;
        while ((c = reader.read()) != -1) {
            System.out.println((char) c);
        }

    }
}
