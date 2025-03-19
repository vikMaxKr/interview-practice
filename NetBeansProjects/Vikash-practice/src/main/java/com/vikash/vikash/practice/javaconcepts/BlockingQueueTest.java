package com.vikash.vikash.practice.javaconcepts;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    static BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(5);


    public static void main(String[] args) {

        Thread producer= new Thread(()->{
            for(int i=0; i<=10; i++)
            {
                try {
                    System.out.println("producing---"+i);
                    blockingQueue.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer=new Thread(()->{
            for(int i=0; i<=10; i++)
            {
                try{
                    int take=blockingQueue.take();
                    System.out.println("consuming--"+take);
                }catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
        });

        consumer.start();
        producer.start();
    }
}
