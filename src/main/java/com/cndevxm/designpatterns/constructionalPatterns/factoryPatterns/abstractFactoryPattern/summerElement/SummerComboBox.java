package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.summerElement;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.ComboBox;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class SummerComboBox implements ComboBox {
    @Override
    public void display() {
        System.out.println("勾选框显示蓝色");
    }
}
