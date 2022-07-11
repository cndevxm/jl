package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.twoWayAdapter;

public class Clinet {

    public static void main(String[] args) {
        Adapter adapterT = new Adapter(new ConcreteTarget());
        adapterT.playT();

        Adapter adapterA = new Adapter(new ConcreteAdapatee());
        adapterA.playA();
    }
}
