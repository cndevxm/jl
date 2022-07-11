package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.simpleFactoryPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/13
 * Description
 */
public class Client {

    public static void main(String[] args) {
        Chart chart = ChartFactory.getChart("histogram");
        chart.display();
    }
}
