package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.simpleFactoryPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/4
 * Description
 */
public class PieChart implements Chart{

    public PieChart() {
        System.out.println("创建了饼状图");
    }

    @Override
    public void display() {
        System.out.println("显示饼状图");
    }
}
