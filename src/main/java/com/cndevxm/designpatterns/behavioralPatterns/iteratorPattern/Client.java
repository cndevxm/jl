package com.cndevxm.designpatterns.behavioralPatterns.iteratorPattern;

public class Client {

    public static void main(String[] args) {
        AbstractAggregate aggregate = new ConcreteAggregate();
        aggregate.addObject("张三");
        aggregate.addObject("李四");
        aggregate.addObject("王五");
        Iterator iterator = aggregate.createInnerIterator();

        System.out.println("正向遍历：");
        while (!iterator.isLast()) {
            System.out.print(iterator.getNextItem() + "，");
            iterator.next();
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("逆向遍历：");
        while (!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem() + "，");
            iterator.previous();
        }
    }
}
