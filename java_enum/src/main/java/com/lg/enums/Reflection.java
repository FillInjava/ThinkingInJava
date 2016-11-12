package com.lg.enums;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sclg1 on 2016/11/12.
 */
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("------Analyze:"+enumClass+"-----------");
        System.out.println("Interfaces:");
        for(Type type : enumClass.getGenericInterfaces()){
            System.out.println(type);
        }
        System.out.println("BaseClass:"+enumClass.getSuperclass());
        System.out.println("Methods:");
        Set<String> methods = new HashSet<String>();
        for(Method method : enumClass.getMethods()){
            methods.add(method.getName());
        }
        System.out.println(methods);

        return methods;
    }

    public static void main(String[] args) {
        Set<String> exporeMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);

        System.out.println("exporeMethods containsAll enumMethods? "+ exporeMethods.containsAll(enumMethods));

        System.out.println("exporeMethods removeAll enumMethods:");
        exporeMethods.removeAll(enumMethods);
        System.out.println(exporeMethods);
    }

}

enum Explore{
    HERE,THERE
}

