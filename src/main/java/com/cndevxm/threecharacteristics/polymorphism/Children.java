package com.cndevxm.threecharacteristics.polymorphism;

/**
 * Created by Yulin Ma
 * Date 2019/1/15
 * Description
 */
public class Children extends Base{

    @Override
    public void say(Base base) {
        System.out.println("children 和 base");
    }

    public void say(Children children) {
        System.out.println("children 和 children");
    }

    @Override
    public void hello(){
        System.out.println("children hello");
    }

}
