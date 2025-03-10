package com.vikash.vikash.practice.multithread;

public class NotifyTest  {

    private boolean status=false;

    private synchronized void produce()
    {
        try {
            System.out.println("producer producing messages");
            Thread.sleep(2000);
            status=true;
            System.out.println("producer notified to consumer");
            notify();
            System.out.println("producer done task");
        }catch (InterruptedException e)
        {
            System.out.println("Producer interrupted exception");
        }

    }

    private synchronized void consume() {

        try{
            while(!status)
            {
                System.out.println("consumer ready to consume");
                wait();
            }
            System.out.println("consumer consumed messages");

        }catch (InterruptedException e)
        {
            System.out.println("consumer interrupted"+e.getMessage());
        }
    }



    public static void main(String[] args) {
//        NotifyTest notifyTest=new NotifyTest();
//        NotifyTest notifyTest1=new NotifyTest();
//        notifyTest.start();
//        notifyTest1.start();
//        notifyTest.consume();
//        notifyTest1.produce();

        NotifyTest notifyTest=new NotifyTest();

        Thread thread1=new Thread(notifyTest::consume);

        Thread thread2=new Thread(notifyTest::produce);

        thread1.start();
        thread2.start();

    }
}
