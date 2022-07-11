package com.cndevxm.threecharacteristics.inherit.LSP.bean;

/**
 * Created by Yulin Ma
 * Date 2019/2/28
 * Description
 */
public class People {

    private String name;

    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
