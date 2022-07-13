package com.cndevxm.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 关于Atomic类的使用
 * value：值
 * valueOffset：值的内存偏移量，因为是通过对内存的原子性操作来保证操作的原子性的
 * <p>
 * 底层是unsafe的CAS操作
 */
public class Atomic {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        Atomic atomic = new Atomic();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(atomic.new AtomicCheckThread(i * 10, atomicInteger));
            t.setName(String.valueOf(i));
            t.start();
            threadList.add(t);
        }
        for (Thread t : threadList) {
            t.join();
        }
        System.out.println("atomicInteger的值为：" + atomicInteger.intValue());
    }


    // 成员内部类
    private class AtomicCheckThread implements Runnable {

        private int cycles; // 循环次数
        private AtomicInteger atomicInteger;

        public AtomicCheckThread(int cycles, AtomicInteger atomicInteger) {
            this.cycles = cycles;
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                System.out.println("线程" + Thread.currentThread().getName() + "获取的值为：" + atomicInteger.getAndIncrement());
            }
        }
    }
}
