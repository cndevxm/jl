package com.cndevxm.designpatterns.behavioralPatterns.templateMethodpattern;

public class Client {

    public static void main(String[] args) {

        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.handle();
    }
}
