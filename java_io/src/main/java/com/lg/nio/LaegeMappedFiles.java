package com.lg.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件允许我们创建和修改那些因为太大而不能直接放入内存的文件.
 * 有了 内存映射文件，我们可以假定整个文件都存放在内存中，而且完全可以把他们当成非常大的数组来访问.
 * 使用这种方式可以访问很大的文件（2GB）,并很容易的进行修改.
 * 注意底层操作系统的文件映射工具是用来最大化的提高性能.
 * Created by sclg1 on 2016/11/6.
 */
public class LaegeMappedFiles {
    public static final int length = 0x8FFFFFF; //128MB

    public static void main(String[] args) throws Exception{
        MappedByteBuffer out = new RandomAccessFile("test.dat","rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);

        for(int i=0;i<length;i++){
            out.put((byte) 'x');
        }
        System.out.println("Finished Write");
        for (int i = length/2; i < length/2+6; i++) {
            System.out.println((char) out.get(i));
        }
    }
}
