package com.vikash.vikash.practice.multithread;

public class SynchronizedTest {

    public static synchronized void method1() {

        System.out.println(Thread.currentThread().getName() + " is in method1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " is leaving method1");
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " is in method2");
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest=new SynchronizedTest();

        Thread thread1=new Thread(SynchronizedTest::method1, "thread1");
        Thread thread2=new Thread(synchronizedTest::method2, "thread2");

        thread1.start();
        thread2.start();
    }
}
