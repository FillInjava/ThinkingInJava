package com.lg.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 文件映射通常用于极大文件.我们有时候需要对这种巨大的文件进行部分加锁，
 * 以便其他线程可以修改文件中未被枷锁的部分，类似于数据库的行级锁
 * Created by sclg1 on 2016/11/6.
 */
public class LockedMappingFile {
    static final int LENGTH = 0x8FFFFFF;//128M
    static FileChannel fc;

    private static class LockAndModify extends Thread{
        private ByteBuffer buffer;
        private int start, end;

        LockAndModify(ByteBuffer mbb,int start,int end){
            this.start = start;
            this.end = end;
            mbb.limit(end);
            mbb.position(start);
            buffer = mbb.slice();

            start();
        }

        @Override
        public void run() {
            try {
                FileLock fl = fc.lock(start,end,false);
                System.out.println("File Lock:"+start+" to "+end);
                //修改
                while (buffer.position() < buffer.limit()-1){
                    buffer.put((byte)(buffer.get()+1));
                }
                fl.release();
                System.out.println("Released from "+start+" to "+end);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        fc = new RandomAccessFile("test.bat","rw").getChannel();
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE,0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            out.put((byte)'x');
        }

        new LockAndModify(out,0,0+ LENGTH /3);
        new LockAndModify(out,LENGTH/2,LENGTH/2+LENGTH/4);
    }
}
