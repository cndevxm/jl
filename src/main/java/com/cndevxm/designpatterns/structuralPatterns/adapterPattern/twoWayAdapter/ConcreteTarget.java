package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.twoWayAdapter;

public class ConcreteTarget implements Target {
    @Override
    public void playT() {
        System.out.println("TTT");
    }
}
