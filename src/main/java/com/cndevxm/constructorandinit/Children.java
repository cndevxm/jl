package com.cndevxm.constructorandinit;

/**
 * Created by Yulin Ma
 * Date 2019/1/23
 * Description
 */
public class Children extends Base {

    private String childrenName;
    private int childrenAge;

    private static Dog mydog1 = new Dog("haha", 1);
    private static Dog mydog2;

    {
        System.out.println("子类构造代码块1被调用。。。");
        System.out.println(("childrenName:" + this.childrenName + ",childrenAge:" + this.childrenAge));
    }


    public Children() {
        System.out.println("子类无参构造器被调用。。。");
    }

    {
        System.out.println("子类构造代码块2被调用。。。");
    }

    static {
        System.out.println("子类静态代码块被调用。。。");
    }

    public String getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName;
    }

    public int getChildrenAge() {
        return childrenAge;
    }

    public void setChildrenAge(int childrenAge) {
        this.childrenAge = childrenAge;
    }
}
