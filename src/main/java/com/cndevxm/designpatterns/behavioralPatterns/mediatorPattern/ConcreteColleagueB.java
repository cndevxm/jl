package com.cndevxm.designpatterns.behavioralPatterns.mediatorPattern;

public class ConcreteColleagueB extends Colleague {

    @Override
    public void cook() {
        System.out.println("B完成了切菜");
    }

    @Override
    public void wash() {
        System.out.println("B完成了洗衣");
    }

    @Override
    public void clean() {
        System.out.println("B完成了拖地");
    }

}
