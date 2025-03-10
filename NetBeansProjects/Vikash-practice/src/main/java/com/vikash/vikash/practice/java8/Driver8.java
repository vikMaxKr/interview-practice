package com.vikash.vikash.practice.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public class Driver8 {

    public static void main(String[] args) {

        Function<String, Integer> fn= String::length;
        System.out.println(fn.apply("hello"));

        Optional<Integer> sum= Arrays.stream(new Integer[]{1,2,3,4,5})
                .parallel()
                .reduce(Integer::sum);

        System.out.println(sum.get());

    }
}
