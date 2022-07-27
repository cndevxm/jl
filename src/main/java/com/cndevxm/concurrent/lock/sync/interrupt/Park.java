package com.cndevxm.concurrent.lock.sync.interrupt;

import java.util.concurrent.locks.LockSupport;

/**
 * 线程wait时的中断
 */
public class Park {

    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程正常运行
        Thread checkThread = new Thread(new Park().new WaitCheckThread());
        checkThread.start();

        // 中断线程
        checkThread.interrupt();
        checkThread.join();
    }

    // 成员内部类
    private class WaitCheckThread implements Runnable {

        @Override
        public void run() {

            LockSupport.park();
        }
    }
}
