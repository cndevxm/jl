package com.cndevxm.designpatterns.behavioralPatterns.templateMethodpattern;

public class ConcreteClass extends AbstractClass {

    @Override
    public void eat() {
        System.out.println("吃意大利面");
    }

    @Override
    public boolean haveTea() {
        return true;
    }
}
