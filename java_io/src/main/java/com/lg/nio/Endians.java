package com.lg.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;

/**
 * big endian(高位优先):将重要的字节放在地址最低的存储器单元
 * little endian(低位优先):将重要的字节放在地址最高的存储器单元
 *
 * 当存储量大于一个字节时，像int,float等，就要考虑字节的顺序问题了。
 *
 * ByteBuffer 是以高位优先的形式存储数据的，并且数据在网络上传输时也经常使用高位优先的形式.
 *
 * -----------------Think in java 中文版.P958.字节存放次序--------------------
 *
 * Created by sclg1 on 2016/11/6.
 */
public class Endians {
    public static void main(String[] args) {
       ByteBuffer bb = ByteBuffer.wrap(new byte[12]);

        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);//big endian(高位优先):将重要的字节放在地址最低的存储器单元
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);//little endian(低位优先):将重要的字节放在地址最高的存储器单元
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

        /*
        [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
        [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
        [97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]*/
    }
}
