package com.cndevxm.concurrent.lock.locks.locksupport;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 验证线程中断是否对park操作有影响，线程中断会对park操作产生影响
 */
public class LockSupportInterruptCheck {

    @SneakyThrows
    public static void main(String[] args) {

        Thread thread = new Thread(new LockSupportInterruptCheckThread());
        thread.start();
        TimeUnit.SECONDS.sleep(10);
        thread.interrupt();
    }

    // 静态内部类
    private static class LockSupportInterruptCheckThread implements Runnable {

        @SneakyThrows
        @Override
        public void run() {

            for (; ; ) {
                System.out.println("LockSupportCheckThread正在运行");
                LockSupport.park();
                System.out.println("线程中断状态为：" + Thread.interrupted());
                System.out.println("LockSupportCheckThread解除阻塞正在运行");
            }
        }
    }
}
