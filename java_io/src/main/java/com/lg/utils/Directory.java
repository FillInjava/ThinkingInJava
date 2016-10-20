package com.lg.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by sclg1 on 2016/10/20.
 */
public class Directory {

    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern  = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }

    /**
     * 递归目录
     * @return
     */
    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result = new TreeInfo();

        for(File item : startDir.listFiles()){
            if(item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));
            }else{
                if(item.getName().matches(regex)){
                    result.files.add(item);
                }
            }
        }

        return result;
    }

    /**
     * 根据路径和正则表达式获取目录树
     * @param startPath
     * @param regex
     * @return
     */
    public static TreeInfo walk(String startPath,String regex){
        return recurseDirs(new File(startPath),regex);
    }

    /**
     * 根据文件对象和正则表达式获取目录树
     * @param file
     * @param regex
     * @return
     */
    public static TreeInfo walk(File file,String regex){
        return recurseDirs(file,regex);
    }

    /**
     * 获取当前文件下的所有文件
     * @param start
     * @return
     */
    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    /**一个二元组用来存储一对对象*/
    public static class TreeInfo implements Iterable<File>{

        public List<File> files = new ArrayList<File>();//普通文件
        public List<File> dirs = new ArrayList<File>();//目录

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo others){
            files.addAll(others.files);
            dirs.addAll(others.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs)+
                    "\n\nfiles:"+PPrint.pformat(files);
        }
    }

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println(walk("."));
        }else{
            for(String arg: args){
                System.out.println(walk(arg));
            }
        }
    }


}
