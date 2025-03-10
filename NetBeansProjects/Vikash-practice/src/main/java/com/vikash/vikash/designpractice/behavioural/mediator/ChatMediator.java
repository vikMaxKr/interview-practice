package com.vikash.vikash.designpractice.behavioural.mediator;

public interface ChatMediator {

    void addUser(User user);
    void sendMessages(User user, String msg);
}
