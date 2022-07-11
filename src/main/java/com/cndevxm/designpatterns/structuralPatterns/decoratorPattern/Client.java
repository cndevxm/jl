package com.cndevxm.designpatterns.structuralPatterns.decoratorPattern;

public class Client {

    public static void main(String[] args) {

        // 声明具体构件
        Component window = new Window();
        // 装饰具体构件，这里相当于将装饰后的构件重新变为具体构件，方便再次装饰
        ScrollBarDecorator decoratorSB = new ScrollBarDecorator(window);
        // 对装饰后的构件进行再一次的装饰
        BlackBorderDecorator decoratorBB = new BlackBorderDecorator(decoratorSB);

        // 先调用具体构件的放
        decoratorBB.display();
    }
}
