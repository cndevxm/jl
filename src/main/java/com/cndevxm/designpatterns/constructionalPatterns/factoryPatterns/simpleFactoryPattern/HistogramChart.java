package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.simpleFactoryPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/4
 * Description 具体产品
 */
public class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("创建了柱状图");
    }

    @Override
    public void display() {
        System.out.println("显示柱状图");
    }
}
