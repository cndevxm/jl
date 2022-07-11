package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.summerElement;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.Button;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("按钮显示蓝色");
    }
}
