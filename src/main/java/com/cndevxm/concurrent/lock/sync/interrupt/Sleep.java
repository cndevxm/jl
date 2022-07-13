package com.cndevxm.concurrent.lock.sync.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程sleep时的中断
 */
public class Sleep {

    public static void main(String[] args) throws InterruptedException {

        // 创建线程正常运行
        Thread checkThread = new Thread(new Sleep().new SleepCheckThread());
        checkThread.start();

        // 中断线程
        checkThread.interrupt();
        checkThread.join();
    }

    // 成员内部类
    private class SleepCheckThread implements Runnable {

        @Override
        public void run() {

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("线程sleep时，检测到线程中断，结束执行");
            }
        }
    }
}
