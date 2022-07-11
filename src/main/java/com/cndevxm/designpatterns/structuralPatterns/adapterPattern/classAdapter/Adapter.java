package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.classAdapter;

public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        play();
    }
}
