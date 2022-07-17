package com.cndevxm.concurrent.lock.locks.scenarios;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * 独占锁
 */
public class ReentrantLock implements Lock, java.io.Serializable {

    private static final long serialVersionUID = 7373984872572414699L;
    /**
     * Synchronizer providing all implementation mechanics
     */
    private final Sync sync;

    /**
     * 同步器，包含非公平同步器与公平同步器的
     */
    abstract static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;

        // 为Lock提供访问公平同步器与非公平同步器的统一入口
        abstract void lock();

        /**
         * 非公平同步器快速获取锁的逻辑，实际上包含了获取锁、重入锁的逻辑，如果失败交给AQS来完成最终实现
         * 1、快速尝试获取锁
         * 2、快速尝试是否是重入
         *
         * @param acquires 1或者-1，代表获取锁与释放锁的操作
         * @return 获取锁的结果
         */
        final boolean nonfairTryAcquire(int acquires) {

            final Thread current = Thread.currentThread();
            int c = getState();

            // 如果c==0代表lock还没有被线程获取，尝试通过一次CAS来获取锁
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    // 获取成功，设置独占线程
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {  // 如果当前线程就是独占线程，说明这是重入或者释放锁
                // +1或者-1
                int nextc = c + acquires;
                if (nextc < 0) // 计算的结果小于0肯定是错误的，最小为0
                    throw new Error("Maximum lock count exceeded");

                // 设置state
                setState(nextc);
                return true;
            }
            return false;
        }

        /**
         * 尝试释放锁的逻辑
         *
         * @param releases
         * @return
         */
        protected final boolean tryRelease(int releases) {

            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;

            // 重新设置state的值且删除独占线程
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        /**
         * 判断当前线程是不是获取到锁的线程
         *
         */
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        /**
         * 实例化condition
         *
         */
        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        /**
         * 获取锁的独占线程
         *
         */
        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        /**
         * 获取state，未获取到锁的线程恒未为0
         *
         */
        final int getHoldCount() {
            return isHeldExclusively() ? getState() : 0;
        }

        /**
         * 判断锁是不是已被获取
         */
        final boolean isLocked() {
            return getState() != 0;
        }

        /**
         * 反序列化实例，并重置state状态
         */
        private void readObject(java.io.ObjectInputStream s)
                throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }
    }

    /**
     * 非公平同步器实现
     */
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = 7316153563782823691L;

        /**
         * 以非公平的方式尝试获取锁
         */
        final void lock() {

            // 尝试通过一次CAS操作来获取锁
            if (compareAndSetState(0, 1))
                setExclusiveOwnerThread(Thread.currentThread());
            else
                // 同步AQS的默认实现来获取锁
                acquire(1);
        }

        /**
         * 实现尝试获取锁的逻辑
         */
        protected final boolean tryAcquire(int acquires) {

            // 交给Sync来实现
            return nonfairTryAcquire(acquires);
        }
    }

    /**
     * 公平同步器实现
     */
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -3000897897090466540L;

        /**
         * 以公平方式尝试获取锁
         */
        final void lock() {
            acquire(1);
        }

        /**
         * 实现尝试获取锁的逻辑
         *
         * @param acquires
         * @return
         */
        protected final boolean tryAcquire(int acquires) {

            final Thread current = Thread.currentThread();
            int c = getState();

            // 如果锁未被获取则执行以下逻辑
            if (c == 0) {
                if (!hasQueuedPredecessors() && //
                        compareAndSetState(0, acquires)) {  // 通过一次CAS操作来尝试获取锁
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {  //设置重入次数
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
    }

    /**
     * 实例化可重入锁，并指定为非公平模式
     */
    public ReentrantLock() {
        sync = new NonfairSync();
    }

    /**
     * 实例化可重入锁，并设定公平模式
     */
    public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }

    /**
     * 获取锁
     */
    public void lock() {
        sync.lock();
    }

    /**
     * 获取一个可被中断的锁
     */
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    /**
     * 尝试申请一个锁，快速返回结果
     */
    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    /**
     * 尝试申请一个锁，并在指定时间范围内返回结果
     */
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    /**
     * 释放锁
     */
    public void unlock() {
        sync.release(1);
    }

    /**
     * 创建 condition
     */
    public Condition newCondition() {
        return sync.newCondition();
    }

    /**
     * 获取state，未获取到锁的线程恒未为0
     */
    public int getHoldCount() {
        return sync.getHoldCount();
    }

    /**
     * 判断当前线程是不是获取到锁的线程
     */
    public boolean isHeldByCurrentThread() {
        return sync.isHeldExclusively();
    }

    /**
     * 判断锁是否锁定
     */
    public boolean isLocked() {
        return sync.isLocked();
    }

    /**
     * 判断是否公平锁
     */
    public final boolean isFair() {
        return sync instanceof FairSync;
    }

    /**
     * 获取持有锁的线程
     */
    protected Thread getOwner() {
        return sync.getOwner();
    }

    /**
     * 判断是否有线程在等待锁，不准确
     * 本质上是判断同步队列是否为空
     */
    public final boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    /**
     * 判断给定线程是否在等待此锁，不准确
     * 本质上是判断给定线程是否在同步队列中
     */
    public final boolean hasQueuedThread(Thread thread) {
        return sync.isQueued(thread);
    }

    /**
     * 同步队列长度
     */
    public final int getQueueLength() {
        return sync.getQueueLength();
    }

    /**
     * 同步队列线程
     */
    protected Collection<Thread> getQueuedThreads() {
        return sync.getQueuedThreads();
    }

    /**
     * 判断等待队列是否为空，此操作必须持有锁
     */
    public boolean hasWaiters(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    /**
     * 获取等待队列长度，不准确
     */
    public int getWaitQueueLength(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    /**
     * 获取等待队列线程
     */
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    public String toString() {
        Thread o = sync.getOwner();
        return super.toString() + ((o == null) ?
                "[Unlocked]" :
                "[Locked by thread " + o.getName() + "]");
    }
}
