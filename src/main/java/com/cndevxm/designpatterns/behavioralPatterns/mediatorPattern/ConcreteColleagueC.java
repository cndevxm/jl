package com.cndevxm.designpatterns.behavioralPatterns.mediatorPattern;

public class ConcreteColleagueC extends Colleague {

    @Override
    public void cook() {
        System.out.println("C完成了炒菜");
    }

    @Override
    public void wash() {
        System.out.println("C完成了晾干");
    }

    @Override
    public void clean() {
        System.out.println("C完成了整理房间");
    }

}
