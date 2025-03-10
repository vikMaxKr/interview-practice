package com.vikash.vikash.practice.javaconcepts.cor;

public class InfoLogger extends Logger{

    public InfoLogger()
    {
        this.level=INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("INFO: "+message);
    }
}
