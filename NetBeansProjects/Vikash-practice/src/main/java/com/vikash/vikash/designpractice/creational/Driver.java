package com.vikash.vikash.designpractice.creational;

import com.vikash.vikash.designpractice.creational.builder.House;

public class Driver {

    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
        Singleton singleton1=Singleton.getInstance();

        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());

        House house=new House.Builder()
                .setLocation("bihar")
                .setSwimming(true)
                .build();

        House house1=new House.Builder()
                .setStreet("q12")
                .setLocation("re")
                .build();

        System.out.println(house1);
        System.out.println(house);

        Prototype prototype=new Prototype(1,true, "ame");
        Prototype prototype1=(Prototype) prototype.clone();
        System.out.println(prototype1.getName());


    }
}
