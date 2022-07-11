package com.cndevxm.accessauthority.defaultPackage.children;

import com.cndevxm.accessauthority.defaultPackage.base.Base2;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Children2 extends Base2 {

    @Override
    public String toString() {
        return "Children2{}";
    }

    public static void main(String[] args) {
        Base2 base2 = new Base2();
        System.out.println(base2.toString());

        Children2 children2 = new Children2();
        System.out.println(children2.toString());

        /**
         * 子类无法访问父类对象的default修饰的成员变量
         */
    }
}
