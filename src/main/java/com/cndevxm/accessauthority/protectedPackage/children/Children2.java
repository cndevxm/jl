package com.cndevxm.accessauthority.protectedPackage.children;

import com.cndevxm.accessauthority.protectedPackage.base.Base;
import com.cndevxm.accessauthority.protectedPackage.base.Base3;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Children2 extends Base3 {

    @Override
    public String toString() {
        return "Children2{" +
                "base3Name='" + base3Name + '\'' +
                ", base3Age=" + base3Age +
                ", baseName='" + baseName + '\'' +
                ", baseAge=" + baseAge +
                '}';
    }

    public static void main(String[] args) {
        Base base = new Base();
        System.out.println(base.toString());

        Children2 children2 = new Children2();
        children2.baseName = "children2Name";
        children2.baseAge = 2;
        children2.base3Name = "children2Name";
        children2.base3Age = 3;
        System.out.println(children2.toString());

        Base base2 = new Children2();
        System.out.println(base2.toString());

        /**
         * 子类可以访问非同包下的父类的protected修饰的成员变量
         */

    }
}
