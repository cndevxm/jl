package com.cndevxm.threecharacteristics.polymorphism;

/**
 * Created by Yulin Ma
 * Date 2019/1/15
 * Description
 */
public class Test {

    public static void main(String[] args) {
        Base base = new Base();
        Base baseC = new Children();
        Children children = new Children();
        GrandSon grandSon = new GrandSon();
        GrandDaughter grandDaughter = new GrandDaughter();

        base.hello();
        baseC.hello();
        children.hello();

        /**
         * 有以上结果得出方法是绑定在对象上的而不是绑定在指针上的
         */

        System.out.println("***************");

        base.say(base);
        base.say(baseC);
        base.say(children);
        base.say(grandSon);
        base.say(grandDaughter);

        System.out.println("***************");

        baseC.say(base);
        baseC.say(baseC);
        baseC.say(children);
        baseC.say(grandSon);
        baseC.say(grandDaughter);

        System.out.println("***************");

        children.say(base);
        children.say(baseC);
        children.say(children);
        children.say(grandSon);
        children.say(grandDaughter);

        /**
         * 对于多态方法的调用顺序为：
         * this,invoke(Obj o);
         * super.invoke(Obj o);
         * this,invoke((super)Obj o);
         * super.invoke((super)Obj o);
         *
         * 备注：this指的是对象而不是栈指针
         *
         */



    }
}
