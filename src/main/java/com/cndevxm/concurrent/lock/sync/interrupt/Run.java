package com.cndevxm.concurrent.lock.sync.interrupt;

/**
 * 线程正常运行时的中断
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {

        // 创建线程正常运行
        Thread checkThread = new Thread(new Run().new RunCheckThread());
        checkThread.start();

        // 中断线程
        checkThread.interrupt();
        checkThread.join();
    }

    // 成员内部类
    private class RunCheckThread implements Runnable {

        boolean interrupted = false;

        @Override
        public void run() {

            while (!interrupted) {
                // 获取线程中断状态
                interrupted = Thread.interrupted();
            }
            System.out.println("监听到线程中断状态，线程结束！");
        }
    }

}


