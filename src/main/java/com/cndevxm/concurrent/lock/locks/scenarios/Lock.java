package com.cndevxm.concurrent.lock.locks.scenarios;

import java.util.concurrent.TimeUnit;

/**
 * Lock接口，定义加锁与解锁操作
 */
public interface Lock {

    /**
     * 获取一个锁，此过程不能被中断，申请锁的过程将被阻塞
     */
    void lock();

    /**
     * 获取一个锁，此过程可被中断，线程中断时将抛出中断异常
     */
    void lockInterruptibly() throws InterruptedException;

    /**
     * 尝试获取一个锁，申请结果将被立即返回
     */
    boolean tryLock();

    /**
     * 尝试获取一个锁，在设定时间内返回申请结果，线程中断时将抛出中断异常
     */
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    /**
     * 解锁，即发布一个锁
     */
    void unlock();

    /**
     * 为当前lock实例创建一个condition对象，此方法必须在当前线程获取lock后调用
     */
    Condition newCondition();
}
