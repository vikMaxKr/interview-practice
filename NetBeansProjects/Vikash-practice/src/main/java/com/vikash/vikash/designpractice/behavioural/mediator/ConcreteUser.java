package com.vikash.vikash.designpractice.behavioural.mediator;

public class ConcreteUser extends User{

    public ConcreteUser(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    protected void send(String message) {
        System.out.println(this.name + " sends: " + message);
        chatMediator.sendMessages(this, message);
    }

    @Override
    protected void receive(String message) {
        System.out.println(this.name + " received: " + message);
    }


}
