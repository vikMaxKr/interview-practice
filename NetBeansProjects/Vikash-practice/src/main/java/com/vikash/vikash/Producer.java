package com.vikash.vikash;

import java.util.LinkedList;
import java.util.Queue;
import java.util.random.RandomGenerator;

public class Producer {

     volatile Queue<Integer> dataStore=new LinkedList<>();

     Thread producer= new Thread(()->{
            while(true) {
                int data = RandomGenerator.getDefault().nextInt();
                dataStore.offer(data);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
     });

     Thread consumer =new Thread(()->{
         while(true) {
             try {
                 Thread.sleep(3000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("Inside consumer");
             if (!dataStore.isEmpty()) {
                 System.out.println(dataStore.poll());
             }
         }
     });
    public static void main(String[] args) {
        Producer producer1=new Producer();
        producer1.producer.start();
        producer1.consumer.start();


    }
}

