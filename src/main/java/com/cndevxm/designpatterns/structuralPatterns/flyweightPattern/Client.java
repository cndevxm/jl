package com.cndevxm.designpatterns.structuralPatterns.flyweightPattern;

public class Client {

    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();

        // 获取三颗棋子
        Flyweight c1 = flyweightFactory.getFlyweight("c");
        Flyweight c2 = flyweightFactory.getFlyweight("c");
        Flyweight c3 = flyweightFactory.getFlyweight("c");

        // 判断三颗棋子是否是同一个对象
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);

        // 给棋子添加外部状态
        c1.display(new Color("白色"));
        c1.display(new Color("黑色"));
    }
}
