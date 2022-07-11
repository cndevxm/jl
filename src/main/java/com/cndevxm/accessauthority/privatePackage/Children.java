package com.cndevxm.accessauthority.privatePackage;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Children extends Base {

    private String childrenName;
    private int childrenAge;

    @Override
    public String
    toString() {
        return "Children{" +
                "childrenName='" + childrenName + '\'' +
                ", childrenAge=" + childrenAge +
                '}';
    }

    public static void main(String[] args) {
        Base base = new Base();

        Children children = new Children();
        children.childrenName = "childrenName";
        children.childrenAge = 2;
        System.out.println(children.toString());

        /**
         * 当前Children与Base属于同一包下且Children继承Base
         * Children无法访问Base的属性
         * 说明private关键字修饰的属性只能当前类访问
         */
    }
}
