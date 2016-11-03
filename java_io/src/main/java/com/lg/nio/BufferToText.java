package com.lg.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * ByteBuffer容纳的是普通字节，为了把他们转成字符，我们要么在输入时对它们进行编码(这样输出时才有意义)，
 * 要么在将其从缓冲器中输出时对它们进行解码.
 *
 * Created by sclg1 on 2016/11/3.
 */
public class BufferToText {
    private final static int BSIZE=1024;

    public static void main(String[] args) throws IOException{
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();//准备输出
        //会乱码，不会如愿输出"Some text"
        System.out.println(buffer.asCharBuffer());

        //使用系统默认的编码
        //回到数据的开始部分
        buffer.rewind();
        //获取默认字符集
        String encoding = System.getProperty("file.encoding");
        System.out.println("使用"+encoding+"解码:"+ Charset.forName(encoding).decode(buffer));
        fc.close();

        //或者在写入字符的时候进行编码:
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some Text".getBytes("UTF-16BE")));
        fc.close();
        //再次读
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();//清空之前的
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        //使用buffer写
        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(24); //这里分配了24个Byte
        buffer.asCharBuffer().put("Some Text");//但实际只用了9*2=18个byte,剩下的6个字节会补0.
        fc.write(buffer);
        fc.close();
        //读
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        fc.close();
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        buffer.rewind();
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
