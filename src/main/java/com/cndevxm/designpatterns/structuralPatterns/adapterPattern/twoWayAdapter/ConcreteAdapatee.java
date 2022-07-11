package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.twoWayAdapter;

public class ConcreteAdapatee implements Adaptee {
    @Override
    public void playA() {
        System.out.println("AAA");
    }
}
