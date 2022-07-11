package com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern;

import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.Button;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.ComboBox;
import com.cndevxm.designpatterns.constructionalPatterns.factoryPatterns.abstractFactoryPattern.baseElement.TextField;

/**
 * Created by Yulin Ma
 * Date 2019/3/6
 * Description
 */
public interface SkinFactory {

    Button createButton();

    ComboBox createComboBox();

    TextField createTextField();
}
