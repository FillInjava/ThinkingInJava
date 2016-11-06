package com.lg.nio;

import java.nio.*;

/**
 * Created by sclg1 on 2016/11/6.
 */
public class ViewsBuffer {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});

        //1 byte = 1byte = 8 bit
        bb.rewind();
        System.out.print("Byte Buffer: ");
        while (bb.hasRemaining()){
            System.out.print(bb.position()+"->"+bb.get()+",");
        }
        System.out.println(" ");

        //1 char = 2 byte
        bb.rewind();
        CharBuffer cb = bb.asCharBuffer();
        System.out.print("Char Buffer: ");
        while (cb.hasRemaining()){
            System.out.print(cb.position()+"->"+cb.get()+",");
        }
        System.out.println(" ");

        //1 short = 2 byte
        bb.rewind();
        ShortBuffer sb = bb.asShortBuffer();
        System.out.print("Short Buffer: ");
        while (sb.hasRemaining()){
            System.out.print(sb.position()+"->"+sb.get()+",");
        }
        System.out.println(" ");

        //1 int = 4 byte
        bb.rewind();
        IntBuffer ib = bb.asIntBuffer();
        System.out.print("Int Buffer: ");
        while (ib.hasRemaining()){
            System.out.print(ib.position()+"->"+ib.get()+",");
        }
        System.out.println(" ");

        //1 float(单精度) = 4 byte
        bb.rewind();
        FloatBuffer fb = bb.asFloatBuffer();
        System.out.print("Float Buffer: ");
        while (fb.hasRemaining()){
            System.out.print(fb.position()+"->"+fb.get()+",");
        }
        System.out.println(" ");

        //1 long = 8 byte
        bb.rewind();
        LongBuffer lb = bb.asLongBuffer();
        System.out.print("Long Buffer: ");
        while (lb.hasRemaining()){
            System.out.print(lb.position()+"->"+lb.get()+",");
        }
        System.out.println(" ");

        //1 double = 8 byte
        bb.rewind();
        DoubleBuffer db = bb.asDoubleBuffer();
        System.out.print("Double Buffer: ");
        while (db.hasRemaining()){
            System.out.print(db.position()+"->"+db.get()+",");
        }
        System.out.println(" ");

    }
}
