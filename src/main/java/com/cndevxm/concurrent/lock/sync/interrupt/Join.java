package com.cndevxm.concurrent.lock.sync.interrupt;

/**
 * 线程join时被中断，本质上是wait时被中断
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {

        // 创建线程正常运行
        Thread checkThread = new Thread(new Join().new JoinCheckThread());
        checkThread.start();

        // 中断线程
        checkThread.interrupt();
        checkThread.join();
    }

    // 成员内部类
    private class JoinCheckThread implements Runnable {

        @Override
        public void run() {

            try {
                Thread t = new Thread(() -> {
                    while (true) {
                    }
                });
                t.start();
                // 等待线程t结束
                t.join();
            } catch (InterruptedException e) {
                System.out.println("线程join时，检测到线程中断，结束执行");
            }
        }
    }

}
