package com.lg.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by sclg1 on 2016/11/3.
 */
public class IntBufferDemo {
    private final static int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        //放一个数组进去
        ib.put(new int[]{11,15,18,79,155,5664,22});
        //读写绝对位置
        System.out.println(bb.get(3));
        ib.put(3,22);
        ib.flip();
        while (ib.hasRemaining()){
            System.out.println(ib.get());
        }

    }
}
