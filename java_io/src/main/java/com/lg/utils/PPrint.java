package com.lg.utils;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by sclg1 on 2016/10/20.
 */
public class PPrint {
    public static String pformat(Collection<?> c){
        if(c.size() == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");

        for(Object ele : c){
            if(c.size() != 1){
                sb.append("\n ");
            }
            sb.append(c);
        }
        if(c.size() != 1){
            sb.append("\n");
        }

        sb.append("]");

        return sb.toString();
    }

    /**
     * 打印集合
     * @param c
     */
    public static void pprint(Collection<?> c){
        System.out.println(pformat(c));
    }

    /**
     * 打印数组
     * @param c
     */
    public static void pprint(Object[] c){
        System.out.println(pformat(Arrays.asList(c)));
    }


}
