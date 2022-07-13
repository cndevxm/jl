package com.cndevxm.concurrent.lock.sync.interrupt;

/**
 * 线程wait时的中断
 */
public class Wait {

    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程正常运行
        Thread checkThread = new Thread(new Wait().new WaitCheckThread());
        checkThread.start();

        // 中断线程
        checkThread.interrupt();
        checkThread.join();
    }

    // 成员内部类
    private class WaitCheckThread implements Runnable {

        @Override
        public void run() {

            synchronized (lock) {
                try {
                    // 将当前线程放进lock的waitSet中，无限期等待
                    // 必须在同步代码块中执行wait()方法
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("线程wait时，检测到线程中断，结束执行");
                }
            }
        }
    }
}
