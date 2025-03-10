/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PracticeCode;

/**
 *
 * @author vikashkumar
 */
public class ThreadP extends Thread{
    
    
    @Override
    public void run()
    {
        for(int i=0;i<5;i++){
        try{
            Thread.sleep(500);
             System.out.println(Thread.currentThread().getName());
        }
        catch(InterruptedException e)
        
        {
            System.out.println(e);
        }
        System.out.println(i);
        }
    }
    
    public static void main(String[] args)
    {
        ThreadP tp=new ThreadP();
        ThreadP tp1=new ThreadP();
       // ThreadP tp2=new ThreadP();
        
//        Thread th=new Thread(tp);
//         Thread th1=new Thread(tp1);
        tp.start();
        
        try{
             System.out.println(Thread.currentThread().getName());
            tp.join();
           
            
        }
        catch(InterruptedException e)
        {
             System.out.println("from main"+e);
        }
        
        tp1.start();
        
    }
    
}
