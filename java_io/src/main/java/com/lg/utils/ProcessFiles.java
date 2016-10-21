package com.lg.utils;

import java.io.File;
import java.io.IOException;

/**
 * 策略模式
 * Created by liuguo on 2016/10/21.
 */
public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;

    private String regex;

    /**
     * 提供一个策略来处理文件
     *
     * @param strategy 策略
     * @param regex    正则表达式
     */
    public ProcessFiles(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regex)) {
            strategy.process(file);
        }
    }

    public void start(String[] args) {

        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        /*if(!arg.endsWith("."+ext)){
                            arg += "."+ext;
                        }*/
                        if (fileArg.getName().matches(regex)) {
                            strategy.process(new File(arg).getCanonicalFile());
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println("file = [" + file + "]");
            }
        }, "D.*\\.java").start(args);

        System.out.println("******************************");
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println("file = [" + file.getPath() + "]");
            }
        }, "D.*\\.java").start(new String[]{"E:\\mypractice\\ThinkingInJava\\.\\java_io\\src\\main\\java\\com\\lg\\io\\unit1"});

        System.out.println("******************************");
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println("AbsolutePath = [" + file.getAbsolutePath() + "]");
                System.out.println("Path = [" + file.getPath() + "]");
                System.out.println("Name = [" + file.getName() + "]");
            }
        }, "D.*\\.java").start(new String[]{".\\java_io\\src\\main\\java\\com\\lg\\io\\unit1\\DirectoryDemo.java"});
    }
}
