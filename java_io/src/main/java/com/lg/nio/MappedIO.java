package com.lg.nio;

import java.io.*;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * IO流和映射文件的性能比较
 * Created by sclg1 on 2016/11/6.
 */
public class MappedIO {
    private final static int numOfInts = 4000000;
    private final static int numOfUbuffers = 200000;

    private abstract static class Tester{
        private String name;
        public Tester(String name){this.name = name;}

        public void runTest(){
            try {
                System.out.println(name+": ");
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n",duration/1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester[] testers = {
      new Tester("Stream write") {
              @Override
              public void test() throws IOException {
                  DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("temp.tmp")));
                  for (int i = 0; i < numOfInts ; i++) {
                      out.writeInt(1);
                  }
                  out.close();
              }
      },new Tester("Mapped write") {
              @Override
              public void test() throws IOException {

                  FileChannel fc = new RandomAccessFile(new File("temp.tmp"),"rw").getChannel();
                  //因为此处的内存映射文件使用的是Read_Write，所以上面的channel只能由支持读写的RandomAccessFile取的，
                  // 而不能使用fc = new FileOutputStream(new File("temp.tmp")).getChannel()
                  IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
                  for (int i = 0; i < numOfInts; i++) {
                      ib.put(i);
                  }
                  fc.close();
              }
      },new Tester("Stream read") {
            @Override
            public void test() throws IOException {
                DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("temp.tmp")));
                for (int i = 0; i < numOfInts; i++) {
                    in.read();
                }
                in.close();
            }
      },new Tester("Mapped read") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new FileInputStream(new File("temp.tmp")).getChannel();
                //同理此处使用的是Read_Only模式，所以channel只需要从输入流取的即可.
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size()).asIntBuffer();
                while (ib.hasRemaining()){
                    ib.get();
                }
                fc.close();
            }
      },new Tester("Stream read/write") {
        @Override
        public void test() throws IOException {
           RandomAccessFile raf = new RandomAccessFile(new File("temp.tmp"),"rw");
            raf.writeInt(1);
            for (int i = 0; i < numOfUbuffers; i++) {
                raf.seek(raf.length()-4);
                raf.writeInt(raf.readInt());
            }
        }
      },new Tester("Mapped read/write") {
        @Override
        public void test() throws IOException {
            FileChannel fc = new RandomAccessFile(new File("temp.tmp"),"rw").getChannel();
            IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE,0,fc.size()).asIntBuffer();
            ib.put(0);
            for (int i = 1; i < numOfUbuffers; i++) {
                ib.put(ib.get(i-1));
            }
            fc.close();
        }
     }
    };

    public static void main(String[] args) {
        for (Tester tester : testers){
            tester.runTest();
        }
    }
}
