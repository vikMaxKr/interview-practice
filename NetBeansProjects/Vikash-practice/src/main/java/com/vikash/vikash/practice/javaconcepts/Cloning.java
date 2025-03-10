package com.vikash.vikash.practice.javaconcepts;

public class Cloning implements Cloneable{

    private String id;
    private Demo demo;

    public Cloning(String id, Demo demo) {
        this.id = id;
        this.demo = demo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

    //shallow copy
//    @Override
//    public Object clone() throws CloneNotSupportedException
//    {
//        return super.clone();
//    }

    //Deep copy
    public Cloning deepClone() throws CloneNotSupportedException
    {
        Cloning deepClone=(Cloning) super.clone();
        deepClone.demo=(Demo) demo.clone();
        return deepClone;
    }




}

class Demo implements Cloneable{

    private String name;
    private String roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public Demo(String name, String roll)
    {
        this.name=name;
        this.roll=roll;
    }

    @Override
    public Object clone() throws  CloneNotSupportedException{
        return super.clone();
    }
}
