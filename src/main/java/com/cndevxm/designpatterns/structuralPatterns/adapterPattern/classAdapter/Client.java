package com.cndevxm.designpatterns.structuralPatterns.adapterPattern.classAdapter;

public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}
