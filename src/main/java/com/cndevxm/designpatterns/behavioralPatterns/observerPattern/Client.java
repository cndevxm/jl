package com.cndevxm.designpatterns.behavioralPatterns.observerPattern;

public class Client {

    public static void main(String[] args) {

        AbstractSubject as = new ConcreteSubject();

        as.attach(new ConcreteObserver("观察者A"));
        as.attach(new ConcreteObserver("观察者B"));
        as.attach(new ConcreteObserver("观察者C"));

        as.notify("");
    }
}
