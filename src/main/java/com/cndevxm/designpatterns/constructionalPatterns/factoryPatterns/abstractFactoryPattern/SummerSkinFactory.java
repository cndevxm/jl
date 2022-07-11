package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.Button;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.ComboBox;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.TextField;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.summerElement.SummerButton;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.summerElement.SummerComboBox;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.summerElement.SummerTextField;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class SummerSkinFactory extends AbstractSkinFactory {

    @Override
    public Button createButton() {
        System.out.println("创建蓝色按钮");
        return new SummerButton();
    }

    @Override
    public ComboBox createComboBox() {
        System.out.println("创建蓝色勾选框");
        return new SummerComboBox();
    }

    @Override
    public TextField createTextField() {
        System.out.println("创建蓝色文本域");
        return new SummerTextField();
    }
}
