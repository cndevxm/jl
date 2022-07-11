package com.cndevxm.designpatterns.behavioralPatterns.chainOfReponsibitilityPattern;

public class ConcreteHandlerA extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("a".equals(request)) {
            System.out.println("A处理了请求");
        } else {
            this.successor.handleRequest(request);
        }
    }
}
