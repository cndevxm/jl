package com.cndevxm.designpatterns.behavioralPatterns.observerPattern;

public class ConcreteSubject extends AbstractSubject {

    @Override
    public void notify(Object args) {
        System.out.println("目标类更改了状态");
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}
