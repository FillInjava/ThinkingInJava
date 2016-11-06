package com.lg.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * JDK1.4引入了加锁机制，它允许我们同步访问作为共享的文件。
 * 不过，竞争同一文件的两个线程可能在不同的java虚拟机上，或者一个是java线程，另一个是操作系统中某个本地线程。
 * 文件锁对其他的操作系统进程是可见的，因为java的文件锁直接影射了本地操作系统的加锁工具.
 *
 * tryLock()是非阻塞的，它设法获取锁，如果不能获得(当其他线程已持有相同的锁，并且不共享时)，他将直接从方法调用返回
 * lock()是阻塞式的，它要阻塞进程直至锁可以获得，或调用lock的线程中断，或调用lock的通道关闭。
 *
 * 使用FileLock.release()可以释放锁
 *
 * --------------------Think in java.中文版.P566.文件加锁-----------------------------
 * Created by sclg1 on 2016/11/6.
 */
public class FileLocking {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("text.txt");
        System.out.println("FileLock test");
        FileLock lock = fos.getChannel().tryLock();
        if(lock !=null ){
            System.out.print("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            lock.release();//释放锁
            System.out.println("Released lock");
        }
        fos.close();
    }
}
