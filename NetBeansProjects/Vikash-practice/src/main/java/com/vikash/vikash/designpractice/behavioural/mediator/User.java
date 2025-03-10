package com.vikash.vikash.designpractice.behavioural.mediator;

public abstract class User {
    protected ChatMediator chatMediator;
    protected String name;

    public User(ChatMediator chatMediator, String message)
    {
        this.chatMediator=chatMediator;
        this.name=message;
    }

    protected abstract void send(String message);
    protected abstract void receive(String message);
}
