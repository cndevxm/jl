package com.cndevxm.designpatterns.constructionalPatterns.singletonPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/8
 * Description 饿汉式单例模式
 */
public class EagerSingleton {

    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("饿汉式构造器被调用");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }
}
