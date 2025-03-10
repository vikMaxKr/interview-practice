package com.vikash.vikash.designpractice.creational.abstractFactory;

public class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckbox();
    }
}
