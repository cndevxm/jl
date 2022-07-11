package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.twoWayAdapter;

public class Adapter implements Adaptee, Target {

    private Target target;
    private Adaptee adaptee;

    public Adapter() {
    }

    public Adapter(Target target) {
        this.target = target;
    }

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void playA() {
        adaptee.playA();
    }

    @Override
    public void playT() {
        target.playT();
    }
}
