package com.cndevxm.designpatterns.constructionalPatterns.singletonPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/8
 * Description 静态内部类单例模式
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
        {
            System.out.println("静态内部类构造器被调用");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class HolderClass {
        private static final StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return HolderClass.staticInnerClassSingleton;
    }
}
