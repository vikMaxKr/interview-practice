package com.vikash.vikash.practice.javaconcepts;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {


    public static void main(String[] args) {
        int coreCount=Runtime.getRuntime().availableProcessors();
        ExecutorService executorService= Executors.newFixedThreadPool(coreCount);
        System.out.println(coreCount);

    }
}
