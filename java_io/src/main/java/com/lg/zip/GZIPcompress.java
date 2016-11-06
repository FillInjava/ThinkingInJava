package com.lg.zip;

/**
 * Created by sclg1 on 2016/11/6.
 */
public class GZIPcompress {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println(
                    "Usage: \nGZIPcompress file\n"+
                            "\tUses GZIP compress to compress"+
                            "the file to test.gz"
            );

            System.exit(1);
        }


    }
}
