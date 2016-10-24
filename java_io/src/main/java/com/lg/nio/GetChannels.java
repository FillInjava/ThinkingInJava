package com.lg.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sclg1 on 2016/10/24.
 */
public class GetChannels {
    public static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{

            FileOutputStream out = new FileOutputStream("data.txt");
            FileChannel fc = out.getChannel();
            fc.write(ByteBuffer.wrap("Hello".getBytes()));
            fc.close();

            RandomAccessFile ra = new RandomAccessFile("data.txt","rw");
            fc = ra.getChannel();
            fc.position(fc.size());//Move To The END
            fc.write(ByteBuffer.wrap(" World!".getBytes()));
            fc.close();

            FileInputStream in = new FileInputStream("data.txt");
            fc = in.getChannel();
            ByteBuffer bb = ByteBuffer.allocate(BSIZE);
            fc.read(bb);
            bb.flip();
            while (bb.hasRemaining()){
                System.out.print((char)bb.get());
            }

    }
}
