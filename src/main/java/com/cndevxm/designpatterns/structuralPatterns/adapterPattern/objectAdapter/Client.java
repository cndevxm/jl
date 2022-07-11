package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.objectAdapter;

public class Client {

    public static void main(String[] args) {
        Taget t = new Adapter();
        t.play("a");
        t.play("b");
    }
}
