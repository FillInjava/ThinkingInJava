package com.java8.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by liuguo on 2016/8/31.
 */
public class ArraysSort {
    public static void main(String[] args) {
        Dog d1 = new Dog("Max",2,50);
        Dog d2 = new Dog("Rocky", 1, 30);
        Dog d3 = new Dog("Bear", 3, 40);

        Dog[] dogArray = { d1, d2, d3 };
        printDogs(dogArray);

      /*  Arrays.sort(dogArray, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getHeight()-o2.getHeight();
            }
        });*/

      //use java8 lambda
        Arrays.sort(dogArray,(Dog m,Dog n) -> m.getWeight()-n.getWeight());
        printDogs(dogArray);

        //use stream
        System.out.println("************use Stream***********");
        Stream<Dog> dogStream = Stream.of(dogArray);
        Stream<Dog> sortedDogStream = dogStream.sorted((m,n)->Integer.compare(m.getWeight(),n.getWeight()));
        sortedDogStream.forEach(n-> System.out.println(n));

    }

    private static void printDogs(Dog[] dogArray) {
        System.out.println("--Dog List--");
        for (Dog d : dogArray)
            System.out.print(d);
        System.out.println();
    }

}
