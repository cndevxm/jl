package com.cndevxm.threecharacteristics.polymorphism;

/**
 * Created by Yulin Ma
 * Date 2019/1/15
 * Description
 */
public class Base {

    public void say(Base base){
        System.out.println("base 和 base");
    }

    public void say(GrandSon grandSon){
        System.out.println("base 和 grandSon");
    }

    public void hello(){
        System.out.println("base hello");
    }
}
