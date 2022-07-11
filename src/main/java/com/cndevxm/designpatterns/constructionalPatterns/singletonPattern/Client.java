package com.cndevxm.designpatterns.constructionalPatterns.singletonPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Yulin Ma
 * Date 2019/3/8
 * Description
 */
public class Client {

    public static void main(String[] args) {

        // 通过多线程的方式去请求单例类，伪造高并发的情况，会出现多次实例化的情况
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // EagerSingleton.getInstance();
                    // LazySingleton.getInstance();
                    // DoubleCheckSingleton.getInstance();
                    StaticInnerClassSingleton.getInstance();
                }
            };
            executor.execute(runnable);
        }
    }
}
