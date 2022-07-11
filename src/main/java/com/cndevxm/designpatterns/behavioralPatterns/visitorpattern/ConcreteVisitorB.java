package com.cndevxm.designpatterns.behavioralPatterns.visitorpattern;

public class ConcreteVisitorB implements Visitor {

    @Override
    public void visit(Element element) {

        if ("sh".equals(element.getAddress())) {
            System.out.println("对上海群众进行了处理");
        } else {
            System.out.println("对北京群众进行了处理");
        }
        System.out.println("访问人为：" + element.getName());
    }
}
