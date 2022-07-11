package com.cndevxm.designpatterns.structuralPatterns.decoratorPattern;

public class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("显示黑色边框");
    }
}
