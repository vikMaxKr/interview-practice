package com.vikash.vikash.designpractice.behavioural.mediator;

public class MediatorDriver {
    public static void main(String[] args) {
        ChatMediator chatMediator=new ChatRoom();

        User user=new ConcreteUser(chatMediator, "Alice");
        User user1=new ConcreteUser(chatMediator, "Bob");
        User user2=new ConcreteUser(chatMediator, "Vikas");
        User user3=new ConcreteUser(chatMediator, "Kr");

        chatMediator.addUser(user);
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        user.send("Hello Everyone");
        user1.send("Hi Alice");


    }
}
