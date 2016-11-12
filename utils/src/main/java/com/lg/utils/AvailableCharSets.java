package com.lg.utils;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * Created by sclg1 on 2016/11/3.
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String,Charset> charSet = Charset.availableCharsets();
        Iterator<String> iterator = charSet.keySet().iterator();
        while (iterator.hasNext()){
            String csName = iterator.next();
            System.out.print(csName);
            //别名
            Iterator<String> aliases = charSet.get(csName).aliases().iterator();
            if(aliases.hasNext())
                System.out.print(": ");
            while (aliases.hasNext()){
                System.out.print(aliases.next());
                if(aliases.hasNext()){
                    System.out.print(",");
                }
            }

            System.out.println(" ");
        }
    }
}
