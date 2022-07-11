package com.cndevxm.designpatterns.behavioralPatterns.chainOfReponsibitilityPattern;

public abstract class Handler {

    protected Handler successor;

    public abstract void handleRequest(String request);

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
