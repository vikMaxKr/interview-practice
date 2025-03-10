package com.vikash.vikash.designpractice.creational.abstractFactory;

public class WindowButton implements Button{
    @Override
    public void render() {
        System.out.println("This is window button created");
    }
}
