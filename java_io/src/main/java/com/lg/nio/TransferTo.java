package com.lg.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * Created by sclg1 on 2016/10/24.
 */
public class TransferTo {
    public static void main(String[] args) throws Exception{
        if(args.length !=2){
            System.out.println("Arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();

        in.transferTo(0,in.size(),out);
        //或者:
        //out.transferFrom(in,0,in.size());
    }
}
