package com.cndevxm.designpatterns.behavioralPatterns.chainOfReponsibitilityPattern;

public class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("b".equals(request)) {
            System.out.println("B处理了请求");
        } else {
            this.successor.handleRequest(request);
        }
    }
}
