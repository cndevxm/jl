package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.springElement;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.TextField;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class SpringTextField implements TextField {

    @Override
    public void display() {
        System.out.println("文本域显示绿色");
    }
}
