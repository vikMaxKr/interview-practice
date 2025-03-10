package com.vikash.vikash.designpractice.creational;

//public class Singleton {
//
//    private static final Singleton INSTANCE=new Singleton();
//
//    private Singleton() {
//        if(INSTANCE!=null)
//        {
//            throw new IllegalStateException("Instance already created");
//        }
//    }
//
//    public static Singleton getInstance()
//    {
//        return INSTANCE;
//    }
//}

//LAZY
/*
Key Improvements and Explanation:
Thread Safety:
The INSTANCE is initialized only when the InstanceHolder class is loaded. This happens in a thread-safe manner due to the JVM's guarantee that class
loading is synchronized.

Prevention of Reflection Attacks:
The check if (InstanceHolder.INSTANCE != null) ensures that even if someone tries to create another instance using reflection, it will throw an exception.

Lazy Initialization:
The Singleton instance is not created until the getInstance() method is called. This makes the pattern lazy and efficient.
 */
public class Singleton {

    private Singleton() {

        if(InstanceHolder.INSTANCE!=null)
        {
            throw new IllegalStateException("Instance already created");
        }
    }

    public static Singleton getInstance()
    {

        return InstanceHolder.INSTANCE;
    }

    private static class InstanceHolder{

        private static final Singleton INSTANCE=new Singleton();

    }
}


