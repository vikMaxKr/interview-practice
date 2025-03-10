package com.vikash.vikash.practice.javaconcepts.cor;

public class DebugLogger extends Logger{

    public DebugLogger()
    {
        this.level=DEBUG;
    }
    @Override
    protected void write(String message) {
        System.out.println("DEBUG: "+message);
    }
}
