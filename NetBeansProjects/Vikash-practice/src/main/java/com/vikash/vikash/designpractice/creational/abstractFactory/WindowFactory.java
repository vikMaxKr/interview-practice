package com.vikash.vikash.designpractice.creational.abstractFactory;

public class WindowFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }
}
