package com.vikash.vikash.designpractice.behavioural.mediator.cor;

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
