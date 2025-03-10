package com.vikash.vikash.practice.javaconcepts;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    private void testThis()
    {
        System.out.println("This is working from static?");
    }

    public static void main(String[] args) {

        //count no of occurrences of words in a given string
        String str="welcome to code decode and code decode welcome you";
        String[] str1=str.split("\\s+");
        Map<String, Long> res= Stream.of(str1).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        //find duplicates
        List<Integer> list= Arrays.asList(1,2,2,3,4,5,5,6,6,7,7);
        Set<Integer> set=new HashSet<>();
        list.stream().filter(x-> !set.add(x)).collect(Collectors.toSet()).forEach(System.out::println);

        //multiply two number
        Function<Integer, Integer> multiply=num-> num*num;
        System.out.println(multiply.apply(55));

    }
}
