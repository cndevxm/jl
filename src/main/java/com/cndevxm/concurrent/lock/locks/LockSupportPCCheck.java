package com.cndevxm.concurrent.lock.locks;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 验证通过LockSupport来实现生产这与消费者模型
 */
public class LockSupportPCCheck {

    @SneakyThrows
    public static void main(String[] args) {

        Thread thread = new Thread(new LockSupportCheckThread());
        thread.start();
        // 提前执行unpark操作将抵消park操作，但是请注意，执行多次与执行一次效果一致
//        LockSupport.unpark(thread);
//        LockSupport.unpark(thread);
        System.out.println("已执行unpark");
        thread.join();
    }

    // 静态内部类
    private static class LockSupportCheckThread implements Runnable {

        @SneakyThrows
        @Override
        public void run() {

            for (; ; ) {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("LockSupportCheckThread正在运行");
                LockSupport.park();
                System.out.println("LockSupportCheckThread解除阻塞正在运行");
            }
        }
    }
}
