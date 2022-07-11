package com.cndevxm.accessauthority.protectedPackage.children;

import com.cndevxm.accessauthority.protectedPackage.base.Base;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Children {

    public static void main(String[] args) {
        Base base = new Base();
        System.out.println(base.toString());
        /**
         * 不能访问非同包下的类的protected 属性
         */

    }
}
