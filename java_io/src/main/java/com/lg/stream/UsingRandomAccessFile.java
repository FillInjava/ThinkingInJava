package com.lg.stream;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by liuguo on 2016/10/21.
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    public static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.1414);
        }
        rf.writeUTF("文件结尾");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        /**Since a double is always eight bytes
         long, to seek( ) to double number 5 you just multiply 5*8to produce the seek value*/
        rf.seek(5 * 8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
        /**
         Value 0: 0.0
         Value 1: 1.1414
         Value 2: 2.2828
         Value 3: 3.4242
         Value 4: 4.5656
         Value 5: 5.707
         Value 6: 6.8484
         文件结尾
         Value 0: 0.0
         Value 1: 1.1414
         Value 2: 2.2828
         Value 3: 3.4242
         Value 4: 4.5656
         Value 5: 47.0001
         Value 6: 6.8484
         文件结尾
         */
    }

}
