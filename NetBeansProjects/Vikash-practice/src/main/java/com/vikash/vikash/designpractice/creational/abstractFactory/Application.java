package com.vikash.vikash.designpractice.creational.abstractFactory;

public class Application {
    private final Button button;
    private final CheckBox checkBox;

    public Application(GUIFactory guiFactory)
    {
        this.button=guiFactory.createButton();
        this.checkBox=guiFactory.createCheckBox();
    }

    public void render()
    {
        button.render();
        checkBox.render();
    }


}
