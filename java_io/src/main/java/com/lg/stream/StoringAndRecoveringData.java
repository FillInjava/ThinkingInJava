package com.lg.stream;

import java.io.*;

/**
 * Created by liuguo on 2016/10/21.
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("data.txt")));
        out.writeDouble(3.1415926);
        out.writeUTF("这是圆周率.");
        out.writeDouble(1.141413);
        out.writeUTF("这是2的平方根");
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("data.txt")));

        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        /**3.1415926
         这是圆周率.
         1.141413
         这是2的平方根
         */
    }

}
