package com.cndevxm.designpatterns.behavioralPatterns.visitorpattern;

public class SHElement extends Element {

    public SHElement(String name, String address, String sex) {
        super(name, address, sex);
    }

    @Override
    public void accept(Visitor visitor) {

        visitor.visit(this);
        System.out.println("visitor 已对上海群众：" + this.getName() + "进行了处理");
    }
}
