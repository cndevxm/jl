package com.cndevxm.designpatterns.behavioralPatterns.strategypattern;

public class Client {

    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        strategy.doSomething();
        strategy = new ConcreteStrategyB();
        strategy.doSomething();
    }
}
