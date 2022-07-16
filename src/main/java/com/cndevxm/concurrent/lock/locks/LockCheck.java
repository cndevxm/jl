package com.cndevxm.concurrent.lock.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCheck {

    private static Lock lock = new ReentrantLock();
    private static Map<String, Integer> countMap = new ConcurrentHashMap<String, Integer>() {{
        put("count", 0);
    }};

    public static void main(String[] args) throws InterruptedException {

        LockCheck lockCheck = new LockCheck();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(lockCheck.new LockCheckThread(i * 10, countMap));
            t.setName(String.valueOf(i));
            t.start();
            threadList.add(t);
        }
        for (Thread t : threadList) {
            t.join();
        }
        System.out.println("count的值为：" + countMap.get("count"));
    }

    // 成员内部类
    private class LockCheckThread implements Runnable {

        private int cycles; // 循环次数
        private Map<String, Integer> countMap;

        public LockCheckThread(int cycles, Map<String, Integer> countMap) {
            this.cycles = cycles;
            this.countMap = countMap;
        }

        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                try {
                    lock.lock();
                    countMap.put("count", countMap.get("count") + 1);
                    System.out.println("线程" + Thread.currentThread().getName() + "获取的值为：" + countMap.get("count"));
                } catch (Throwable t) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
