package com.cndevxm.designpatterns.constructionalPatterns.singletonPattern;

/**
 * Created by Yulin Ma
 * Date 2019/3/8
 * Description 双重检查单例模式
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton() {
        System.out.println("双重检查构造器被调用");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheckSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheckSingleton == null) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}
