package com.cndevxm.designpatterns.behavioralPatterns.visitorpattern;

public class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(Element element) {

        if ("man".equals(element.getSex())) {
            System.out.println("对男性进行了处理");
        } else {
            System.out.println("对女性进行了处理");
        }
        System.out.println("访问人为：" + element.getName());
    }
}
