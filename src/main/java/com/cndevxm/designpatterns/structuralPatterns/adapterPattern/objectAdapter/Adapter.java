package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.objectAdapter;

public class Adapter implements Taget {

    private AdapteeA adapteeA = new AdapteeA();
    private AdapteeB adapteeB = new AdapteeB();

    @Override
    public void play(String flag) {
        if ("a".equals(flag)) {
            adapteeA.play();
        } else if ("b".equals(flag)) {
            adapteeB.play();
        }
    }
}
