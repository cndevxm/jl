package com.cndevxm.designpatterns.behavioralPatterns.chainOfReponsibitilityPattern;

public class ConcreteHandlerC extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("c".equals(request)) {
            System.out.println("C处理了请求");
        }
    }
}
