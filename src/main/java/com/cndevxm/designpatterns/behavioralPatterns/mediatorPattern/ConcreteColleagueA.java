package com.cndevxm.designpatterns.behavioralPatterns.mediatorPattern;

public class ConcreteColleagueA extends Colleague {

    @Override
    public void cook() {
        System.out.println("A完成了洗菜");
    }

    @Override
    public void wash() {
        System.out.println("A完成了放水");
    }

    @Override
    public void clean() {
        System.out.println("A完成了扫地");
    }

}
