package com.vikash.vikash.designpractice.behavioural.mediator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class ChatRoom implements ChatMediator{
    private Set<User> users=new HashSet<>();

    @Override
    public void addUser(User user) {
      users.add(user);
    }

    @Override
    public void sendMessages(User user, String msg) {

        for (User value : users) {
            if (!Objects.equals(value.name, user.name)) {
                value.receive(msg);
            }
        }
    }
}
