package com.cndevxm.concurrent.lock.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 验证无锁、偏向锁、轻量级锁、重量级锁的对象头的值
 * <p>
 * 对象头的构造
 * |-----------------------------------------------------------------------------------------------------------------------------|
 * |                                              Object Header (128 bits)                                                       |
 * |-----------------------------------------------------------------------------------------------------------------------------|
 * |                        Mark Word (64 bits)                                                   |      Klass Word (64 bits)    |
 * |-----------------------------------------------------------------------------------------------------------------------------|
 * | unused:25bit | identity_hashcode:31 | unused:1 | 年龄分代:4 | biased_lock:1（0） | lock:2（01） | OOP to metadata object |  无锁
 * |--------------------------------------------------------------------------------|-------------|------------------------------|
 * | 偏向线程id:54bit |      偏向时间戳:2   | unused:1 | 年龄分代:4 | biased_lock:1（1） | lock:2（01） |     OOP to metadata object   |  偏向锁
 * |-------------------------------------------------------------------------------|--------------|------------------------------|
 * |                     线程栈中锁记录指针:62                                         | lock:2（00） |     OOP to metadata object   |  轻量锁
 * |-------------------------------------------------------------------------------|--------------|------------------------------|
 * |                     重量级锁对象监视器指针:62                                     | lock:2（10） |     OOP to metadata object   |  重量锁
 * |-------------------------------------------------------------------------------|-------------|------------------------------|
 * |                        GC标记信息                                               | lock:2（11） |     OOP to metadata object   |    GC
 * |-----------------------------------------------------------------------------------------------------------------------------|
 * <p>
 * 验证条件：
 * 1、jdk1.8
 * 2、关闭指针压缩，-XX:-UseCompressedOops
 * 验证结果：
 * 总体来说，锁升级的方向是没有错的，但是偏向锁升级到轻量级锁、轻量级锁升级到重量级锁的边界很模糊
 */

public class ObjectHeader {

    public static void main(String[] args) throws InterruptedException {

        // 虚拟机启动后，前四秒生成的对象为无锁状态，如果发生了资源竞争则直接升级到轻量级锁
        ObjectHeader a = new ObjectHeader();
        System.out.println(ClassLayout.parseInstance(a).toPrintable()); // 无锁状态

        System.out.println("↑↑↑当前锁对象为无锁状态（non-biasable），触发锁竞争，直接升级为轻量级锁（thin lock）");

        synchronized (a) {
            System.out.println(ClassLayout.parseInstance(a).toPrintable()); // 轻量级锁状态
        }
        System.out.println("↑↑↑当前锁对象为轻量级锁（thin lock）");

        System.out.println("\r\n ********************************************************** \r\n");

        // 虚拟机启动后，经过四秒后生成的对象为匿名偏向锁状态，如果发生了资源竞争则升级到偏向锁
        TimeUnit.SECONDS.sleep(5);
        ObjectHeader b = new ObjectHeader();
        System.out.println(ClassLayout.parseInstance(b).toPrintable()); // 匿名偏向锁状态

        System.out.println("↑↑↑当前锁对象为匿名偏向锁状态（biasable），创建子线程竞争锁资源，直接升级为偏向锁（biased），如果计算了对象的hashcode则直接升级为轻量级锁（thin lock）");

        Thread aThread = new Thread(new CustomThread(b));
        aThread.start();
        aThread.join();
        System.out.println(ClassLayout.parseInstance(b).toPrintable()); // 偏向锁状态

        System.out.println("↑↑↑当前锁对象为偏向锁状态（biased），当创建子线程竞争锁资源时，则偏向锁（biased）状态不变，偏向线程id也未变；当主线程竞争锁资源时，则锁对象升级为轻量级锁（thin lock），很奇怪！！！");
//        Thread bThread = new Thread(new CustomThread(b));
//        bThread.start();
//        bThread.join();
//        TimeUnit.SECONDS.sleep(10); // 会有一定几率出现无锁状态（non-biasable），怀疑是JVM的延迟
//        System.out.println(ClassLayout.parseInstance(b).toPrintable()); // 偏向锁状态

        synchronized (b) {
            System.out.println(ClassLayout.parseInstance(b).toPrintable()); // 轻量级锁状态
        }
        System.out.println("增强竞争锁资源，锁对象升级为重量级锁（fat lock）");
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CustomThread(b));
            t.start();
            threadList.add(t);
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println(ClassLayout.parseInstance(b).toPrintable()); // 重量级锁状态
    }

    static class CustomThread implements Runnable {

        private static ObjectHeader objectHeader;

        public CustomThread(ObjectHeader objectHeader) {
            this.objectHeader = objectHeader;
        }

        @Override
        public void run() {
            synchronized (objectHeader) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
