package com.cndevxm.constructorandinit;

public class Dog {

    private String name;
    private int age;

    Dog(String name, int age) {
        System.out.println("生成了小狗");
        name = name;
        age = age;
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
