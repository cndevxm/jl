package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.springElement;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.ComboBox;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class SpringComboBox implements ComboBox {

    @Override
    public void display() {
        System.out.println("勾选框显示绿色");
    }
}
