package com.vikash.vikash.designpractice.behavioural.mediator.cor;

public class ChainOfResponsibility {

    private static Logger getChainObject()
    {
        Logger infoLogger=new InfoLogger();
        Logger debugLogger=new DebugLogger();
        Logger errorLogger=new ErrorLogger();

        infoLogger.setNextLevel(debugLogger);
        debugLogger.setNextLevel(errorLogger);

        return infoLogger;
    }

    public static void main(String[] args) {

        Logger logger=getChainObject();

        logger.logMessage(Logger.INFO, "This is informational");
       logger.logMessage(Logger.DEBUG,"This is debug message");
        logger.logMessage(Logger.ERROR, "This is error");

    }
}
