package com.cndevxm.designpatterns.behavioralPatterns.visitorpattern;

public class Client {

    public static void main(String[] args) {

        ObjectStructure objectStructure = new ObjectStructure() {{
            add(new SHElement("张三", "sh", "man"));
            add(new BJElement("张老三", "bj", "woman"));
            add(new BJElement("李老四", "bj", "woman"));
            add(new SHElement("王五", "sh", "man"));
            add(new BJElement("王老五", "bj", "woman"));
            add(new SHElement("李四", "sh", "man"));
        }};

        Visitor visitorA = new ConcreteVisitorA();
        objectStructure.handle(visitorA);
        System.out.println("-----------------------");
        Visitor visitorB = new ConcreteVisitorB();
        objectStructure.handle(visitorB);
    }
}
