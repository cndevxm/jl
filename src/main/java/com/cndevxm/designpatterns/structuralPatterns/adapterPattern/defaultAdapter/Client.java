package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.defaultAdapter;

public class Client {

    public static void main(String[] args) {
        Adapter adapter = new ConcreteAdapter();
        adapter.playA();
        adapter.playB();
    }
}
