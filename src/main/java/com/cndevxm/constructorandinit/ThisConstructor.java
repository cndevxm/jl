package com.cndevxm.constructorandinit;

/**
 * Created by Yulin Ma
 * Date 2019/1/11
 * Description
 */
public class ThisConstructor {

    private String name;
    private int age;

    public ThisConstructor(){
        this("张三");
    };

    public ThisConstructor(String name) {
        this(123);
        this.name = name;
    }

    public ThisConstructor(int age) {
        this.age = age;
    }

    public ThisConstructor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        ThisConstructor t1 = new ThisConstructor();
        System.out.println(t1.toString());

        /**
         * 构造器里边调用其他构造器只能用this关键字并且必须是第一行
         */
    }

    @Override
    public String toString() {
        return "ThisConstructor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
