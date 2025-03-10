package com.vikash.vikash.designpractice.creational;

public class Prototype implements Cloneable{
    private int number;
    private boolean isSuccess;
    private String name;

    @Override
    public Object clone()
    {
        try{
            return super.clone();

        }catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prototype(int number, boolean isSuccess, String name) {
        this.number = number;
        this.isSuccess = isSuccess;
        this.name = name;
    }
}
