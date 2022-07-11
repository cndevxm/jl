package com.cndevxm.designpatterns.behavioralPatterns.templateMethodpattern;

public abstract class AbstractClass {

    public void bookATable() {
        System.out.println("预定位置");
    }

    public abstract void eat();

    public void bill() {
        System.out.println("结账");
    }

    public boolean haveTea() {
        return false;
    }

    public void handle() {
        this.bookATable();
        this.eat();
        if (haveTea()) {
            System.out.println("一块再去喝个茶");
        }
        bill();
    }
}
