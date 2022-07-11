package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.Button;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.ComboBox;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.TextField;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public class Client {

    public static void main(String[] args) {

        AbstractSkinFactory abstractSkinFactory = new SpringSkinFactory();
        Button button = abstractSkinFactory.createButton();
        ComboBox comboBox = abstractSkinFactory.createComboBox();
        TextField textField = abstractSkinFactory.createTextField();
        button.display();
        comboBox.display();
        textField.display();
    }
}
