package com.vikash.vikash.practice.javaconcepts;


//EAGER SINGLETON
//public class Singleton {
//
//    private static final Singleton INSTANCE= new Singleton();
//
//    private Singleton()
//    {
//        //prevent reflection based instantiation
//        if(INSTANCE!=null) {
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
public class Singleton {

    public int x=0;
    public String name="vikash";

    // Private constructor prevents instantiation from other classes
    private Singleton() {
        // Prevent reflection-based instantiation
        if (InstanceHolder.INSTANCE != null) {
            throw new IllegalStateException("Instance already created!");
        }
    }

    // Static inner class - loaded only when getInstance() is called
    private static class InstanceHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Global access point for the singleton instance
    public static Singleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    // Example method in the singleton
    public void doSomething() {
        System.out.println("Singleton instance method called!");
    }


}
