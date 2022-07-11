package com.cndevxm.accessauthority.protectedPackage.base;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Base2 {

    public static void main(String[] args) {
        Base base = new Base();
        base.baseName = "baseName";
        base.baseAge = 1;
        System.out.println(base.toString());

        /**
         * 对于类对象的protected属性可以被同包下的类查询到
         *
         */
    }

}
