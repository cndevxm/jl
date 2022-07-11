package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.defaultAdapter;

public abstract class AbstractAdapter implements Adapter {

    @Override
    public void playA() {
        System.out.println("AAA");
    }

    @Override
    public void playB() {
        System.out.println("BBB");
    }
}
