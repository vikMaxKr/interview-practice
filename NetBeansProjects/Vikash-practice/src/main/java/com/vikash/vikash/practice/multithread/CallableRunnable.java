package com.vikash.vikash.practice.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableRunnable {

    static ExecutorService executorService= Executors.newFixedThreadPool(2);


    public static void main(String[] args) {

        Runnable task=()->{
            System.out.println("runnable task running");
        };

        Callable<String> taskCall=()->{
            System.out.println("callable task running");
            return Thread.currentThread().getName();
        };

        executorService.submit(task);
        Future<String> future= executorService.submit(taskCall);

        try{
            System.out.println(future.get());
        }catch (Exception e)
        {
            System.out.println("exception");
        }
        finally {
            executorService.shutdown();
        }
    }
}
