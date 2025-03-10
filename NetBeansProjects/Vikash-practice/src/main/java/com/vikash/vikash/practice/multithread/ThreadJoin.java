package com.vikash.vikash.practice.multithread;

public class ThreadJoin extends Thread{

    @Override
    public void run()
    {
        for(int i=0;i<3;i++)
        {
            try{
                Thread.sleep(1500);
                System.out.println(Thread.currentThread().getName());
            }catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreadJoin threadJoin=new ThreadJoin();
        ThreadJoin threadJoin1=new ThreadJoin();
        threadJoin.start();

        try{
            System.out.println("main thread waiting for first thread to finish");
            threadJoin.join();
            System.out.println("first thread finished task");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        threadJoin1.start();
    }
}
