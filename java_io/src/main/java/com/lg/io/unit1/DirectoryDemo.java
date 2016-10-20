package com.lg.io.unit1;

import com.lg.utils.Directory;
import com.lg.utils.PPrint;

import java.io.File;

/**
 * Created by sclg1 on 2016/10/20.
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        //当前目录下的所有目录
        PPrint.pprint(Directory.walk(".").dirs);
        PPrint.pprint(Directory.walk(".","D.*").files);
    }
}
