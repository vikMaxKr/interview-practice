package com.vikash.vikash.designpractice.behavioural.mediator.cor;

public abstract class Logger {

    public static int INFO=1;
    public static int DEBUG=2;
    public static int ERROR=3;

    protected int level;
    protected Logger nextLogger;

    protected void setNextLevel(Logger nextLevel)
    {
        this.nextLogger=nextLevel;

    }

    public void logMessage(int level, String msg)
    {
        if(this.level<=level)
        {
            this.write(msg);
        }
        if(nextLogger!=null)
        {
            nextLogger.logMessage(level, msg);
        }
    }

    protected abstract void write(String message);
}
