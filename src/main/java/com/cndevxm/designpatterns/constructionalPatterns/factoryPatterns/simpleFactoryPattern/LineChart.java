package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.simpleFactoryPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/4
 * Description
 */
public class LineChart implements Chart{

    public LineChart() {
        System.out.println("创建了折线图");
    }

    @Override
    public void display() {
        System.out.println("显示折线图");
    }
}
