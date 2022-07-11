package com.cndevxm.accessauthority.defaultPackage.base;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Children extends Base{

    public static void main(String[] args) {

        Base base = new Base();
        base.baseName = "baseName";
        base.baseAge = 1;
        System.out.println(base.toString());

        Children children = new Children();
        children.baseName = "childrenName";
        children.baseAge = 2;
        System.out.println(children.toString());
        /**
         * 子类可以访问同包下的default修饰的父类，且访问父类的default修饰的成员变量
         */

    }
}
