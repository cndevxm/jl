package com.cndevxm.accessauthority.publicPackage;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Children extends Base {

    @Override
    public String toString() {
        return "Children{" +
                "baseName='" + baseName + '\'' +
                ", baseAge=" + baseAge +
                '}';
    }

    public static void main(String[] args) {
        Base base = new Base();
        base.baseName = "publishBase";
        base.baseAge = 1;
        System.out.println(base.toString());

        Children children = new Children();
        children.baseName = "publishChildren";
        children.baseAge = 2;
        System.out.println(children.toString());

        /**
         * publish 权限最大
         * 子类继承父类的publish属性与方法
         */
    }
}
