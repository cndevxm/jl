package com.cndevxm.designpatterns.structuralPatterns.compositePattern.transparentCompositePattern;

public interface Unit {

    void add(Unit unit);

    void remove(Unit unit);

    Unit getChild(int i);

    void sendMessage(String message);
}
