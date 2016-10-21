package com.lg.io.file;

import com.lg.utils.Directory;
import com.lg.utils.PPrint;

/**
 * Created by sclg1 on 2016/10/20.
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        //当前目录下的所有目录
        PPrint.pprint(Directory.walk(".").dirs);
        //当前目录下以D开头的所有文件
        PPrint.pprint(Directory.walk(".","D.*").files);
        //所有的java文件
        PPrint.pprint(Directory.walk(".", "D.*\\.java").files);
        //包含有L或l的java文件
        PPrint.pprint(Directory.walk(".", ".*[Ll].*\\.java").files);
    }
}
