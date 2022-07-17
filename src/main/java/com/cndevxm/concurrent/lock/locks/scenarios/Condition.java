package com.cndevxm.concurrent.lock.locks.scenarios;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Condition接口，定义睡眠与唤醒操作
 */
public interface Condition {

    /**
     * 将当前线程添加到等待队列中，中断时抛出异常
     */
    void await() throws InterruptedException;

    /**
     * 将当前线程添加到等待队列中，线程不能中断只能被唤醒
     */
    void awaitUninterruptibly();

    /**
     * 将当前线程添加到等待队列中，并等待纳秒级时间，指定时间过后线程将被唤醒，此过程可被中断
     */
    long awaitNanos(long nanosTimeout) throws InterruptedException;

    /**
     * 将当前线程添加到等待队列中，并等待指定时间，指定时间过后线程将被唤醒，此过程可被中断
     */
    boolean await(long time, TimeUnit unit) throws InterruptedException;

    /**
     * 将当前线程添加到等待队列中，并等待至指定时间，指定时间过后线程将被唤醒，此过程可被中断
     */
    boolean awaitUntil(Date deadline) throws InterruptedException;

    /**
     * 唤醒等待队列中的一个线程
     */
    void signal();

    /**
     * 唤醒等待队列中的全部线程
     */
    void signalAll();
}
