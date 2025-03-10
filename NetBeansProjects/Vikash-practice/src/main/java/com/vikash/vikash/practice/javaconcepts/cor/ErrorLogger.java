package com.vikash.vikash.practice.javaconcepts.cor;

public class ErrorLogger extends Logger{

    public ErrorLogger()
    {
        this.level=ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("ERROR: "+message);
    }
}
