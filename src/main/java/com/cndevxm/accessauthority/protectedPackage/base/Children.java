package com.cndevxm.accessauthority.protectedPackage.base;

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
         * 对于类对象的protected属性可以被同包下的继承类查询到
         */

    }
}
