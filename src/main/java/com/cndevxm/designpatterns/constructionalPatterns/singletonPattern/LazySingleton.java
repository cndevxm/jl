package com.cndevxm.designpatterns.constructionalPatterns.singletonPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/8
 * Description 懒汉式单例模式
 */
public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton() {
        System.out.println("懒汉式构造器被调用");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
