package com.lg.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by sclg1 on 2016/10/21.
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException{

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile));

        try {
            byte[] data = new byte[in.available()]; //产生适合长度的byte数组
            in.read(data);
            return data;
        } finally {
            in.close();
        }
    }

    public static byte[] read(String fileName) throws IOException{
        return read(new File(fileName).getAbsoluteFile());
    }
}
