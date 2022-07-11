package com.cndevxm.designpatterns.behavioralPatterns.chainOfReponsibitilityPattern;

public class Client {

    public static void main(String[] args) {
        Handler a, b, c;
        a = new ConcreteHandlerA();
        b = new ConcreteHandlerB();
        c = new ConcreteHandlerC();

        a.setSuccessor(b);
        b.setSuccessor(c);

        a.handleRequest("c");
    }
}
