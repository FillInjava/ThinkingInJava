package com.lg.io.unit1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by sclg1 on 2016/10/16.
 */
public class DirList {
    public static void main(String[] args) {
       /* File files = new File("D:\\myWork\\iotest");
        for(File file : files.listFiles()){
            System.out.println("file = [" + file.getName() + "]");
        }

        for(String fileName : files.list()){
            System.out.println("file = [" + fileName + "]");
        }
        String[] list = files.list(new DirFilter("\\.java$"));
        for(String name:list){
            System.out.println("args = [" + name + "]");
        }*/

       File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            list = path.list(new DirFilter(args[0]));
        }

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);

        for(String dirItem : list){
            System.out.println("[" + dirItem + "]");
        }
    }

}
class DirFilter implements FilenameFilter{

    private Pattern pattern;

    public DirFilter(String regex){
        pattern  = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
