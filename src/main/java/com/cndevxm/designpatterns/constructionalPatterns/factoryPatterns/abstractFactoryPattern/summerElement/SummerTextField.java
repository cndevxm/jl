package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.summerElement;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.TextField;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("文本域显示蓝色");
    }
}
