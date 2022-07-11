package com.cndevxm.designpatterns.structuralPatterns.flyweightPattern;

public abstract class Flyweight {

    public void display(Color color) {
        System.out.println("棋子的颜色为：" + color.getColor());
    }

}
