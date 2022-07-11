package com.cndevxm.designpatterns.structuralPatterns.decoratorPattern;

public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("显示滚动条");
    }
}
