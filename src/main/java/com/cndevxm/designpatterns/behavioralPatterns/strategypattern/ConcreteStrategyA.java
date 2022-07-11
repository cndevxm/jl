package com.cndevxm.designpatterns.behavioralPatterns.strategypattern;

public class ConcreteStrategyA implements Strategy {

    @Override
    public void doSomething() {
        System.out.println("AAA");
    }
}
