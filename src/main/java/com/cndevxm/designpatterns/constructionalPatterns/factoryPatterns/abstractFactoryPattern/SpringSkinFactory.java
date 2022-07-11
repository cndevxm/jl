package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.Button;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.ComboBox;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.TextField;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.springElement.SpringButton;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.springElement.SpringComboBox;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.springElement.SpringTextField;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class SpringSkinFactory extends AbstractSkinFactory {

    @Override
    public Button createButton() {
        System.out.println("创建绿色按钮");
        return new SpringButton();
    }

    @Override
    public ComboBox createComboBox() {
        System.out.println("创建绿色勾选框");
        return new SpringComboBox();
    }

    @Override
    public TextField createTextField() {
        System.out.println("创建绿色文本域");
        return new SpringTextField();
    }
}
