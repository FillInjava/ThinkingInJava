package com.lg.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 交换两个相邻字符
 * Created by sclg1 on 2016/11/6.
 */
public class UsingBuffers {

    public static void symmetricScramble(CharBuffer buffer){
        while (buffer.hasRemaining()){
            buffer.mark(); //将mark设置为当前position的值
            char a = buffer.get();
            char b = buffer.get();
            buffer.reset();//将position的位置重新设置为之前mark的位置
            buffer.put(b).put(a);
        }
    }

    public static void main(String[] args) {
        char[] datas = "UsingBuffers".toCharArray();
        ByteBuffer bb  = ByteBuffer.allocate(datas.length*2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(datas);

        System.out.println(cb.rewind());

        symmetricScramble(cb);
        System.out.println(cb.rewind());

        symmetricScramble(cb);
        System.out.println(cb.rewind());
    }
}
