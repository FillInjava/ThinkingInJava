package com.lg.nio;

import java.nio.ByteBuffer;

/**
 * 尽管ByteBuffer只能保存字节类型的数据，但是它具有可以从其所容纳的字节中产生各种不同基本类型值的方法.
 * 向ByteBuffer中插入基本类型数据的最简单的方法: 利用asCharBuffer()、asShortBuffer()等获得该
 * 缓冲上的视图，然后使用视图的put()方法.
 *
 * Created by sclg1 on 2016/11/3.
 */
public class GetData {
    private final static int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);//分配时会自动填充0
        int i = 0;
        while (i++ < bb.limit()){
            if(bb.get() !=0 ){
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i );

        bb.rewind();

        //存储和读取字符数组
        bb.asCharBuffer().put("Hello!");
        char c;
        while ((c = bb.getChar())!= 0){
            System.out.print(c+" ");
        }
        System.out.println(" ");

        //存储和读取short
        bb.rewind();
        bb.asShortBuffer().put((short) 407841);
        System.out.println(bb.getShort());

        //int
        bb.rewind();
        bb.asIntBuffer().put(564688790);
        System.out.println(bb.getInt());

        //long
        bb.rewind();
        bb.asLongBuffer().put(547878979);
        System.out.println(bb.getLong());

    }
}
