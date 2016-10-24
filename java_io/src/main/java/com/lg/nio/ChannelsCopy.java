package com.lg.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by sclg1 on 2016/10/24.
 */
public class ChannelsCopy {
    public static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception{
        if(args.length !=2){
            System.out.println("Arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                    out = new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while (in.read(buffer) != -1){
            buffer.flip();//为写做准备
            out.write(buffer);
            buffer.clear();//清空buffer，为下次读作准备
        }
    }
}
