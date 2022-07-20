package com.cndevxm.concurrent.lock.locks.sourceAnalyize;

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
     * 获取锁，过程不可中断
     * 本质上是线程在等待获取锁时，如果发生了线程中断，则将线程设置为中断状态不处理
     */
    public void lock() {

        sync.lock();
    }

    /**
     * 获取锁，过程可中断
     * 本质上是线程在等待获取锁时，如果发生了线程中断，则直接抛出异常
     */
    public void lockInterruptibly() throws InterruptedException {

        sync.acquireInterruptibly(1);
    }

    /**
     * 获取锁，直接返回结果，失败不添加到同步队列中
     */
    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    /**
     * 获取锁，在指定时间范围内获取，过程可中断
     * 如果在时间范围内未获取到锁会先挂起一段时间再尝试，直到超时，如果发生了线程中断，则直接抛出异常
     */
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    /**
     * 创建condition对象
     */
    public Condition newCondition() {
        return sync.newCondition();
    }

    /**
     * 获取state，未获取到锁的线程恒为0
     */
    public int getHoldCount() {
        return sync.getHoldCount();
    }

    /**
     * 判断锁是否已被获取
     */
    public boolean isLocked() {
        return sync.isLocked();
    }

    /**
     * 释放锁
     */
    public void unlock() {
        sync.release(1);
    }

    /**
     * 判断是否为公平锁
     */
    public final boolean isFair() {
        return sync instanceof FairSync;
    }

    /**
     * 判断是否有线程在等待锁，不准确
     * 本质上是判断同步队列是否有线程在等待
     */
    public final boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    /**
     * 判断当前线程是不是获取到锁的线程
     */
    public boolean isHeldByCurrentThread() {
        return sync.isHeldExclusively();
    }

    /**
     * 同步队列长度，不准确
     */
    public final int getQueueLength() {
        return sync.getQueueLength();
    }

    /**
     * 同步队列线程，不准确
     */
    protected Collection<Thread> getQueuedThreads() {
        return sync.getQueuedThreads();
    }

    /**
     * 获取持有锁的线程
     */
    protected Thread getOwner() {
        return sync.getOwner();
    }

    /**
     * 获取等待队列线程，不能准
     */
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    /**
     * 判断给定线程是否在等待此锁，不准确
     * 本质上是判断给定线程是否在同步队列中
     */
    public final boolean hasQueuedThread(Thread thread) {
        return sync.isQueued(thread);
    }

    /**
     * 同步器，包含公平锁与非公平锁的共有实现
     */
    abstract static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;

        // 方法抽象
        abstract void lock();

        /**
         * 非公平锁获取锁的逻辑
         * 1、如果锁未被别的线程获取则尝试获取锁
         * 2、如果锁已被自己线程获取则state+1
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
            } else if (current == getExclusiveOwnerThread()) {  // 如果当前线程就是独占线程，说明这是重入
                // +1
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
         * 释放锁，state-1，如果计算后state=0则将独占线程置为null，说明完全释放
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
         */
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        /**
         * 实例化ConditionObject对象
         */
        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        /**
         * 获取锁的独占线程
         */
        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        /**
         * 获取state，未获取到锁的线程恒未为0
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
     * 非公平锁获取锁的逻辑
     */
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = 7316153563782823691L;

        /**
         * 以非公平的方式尝试获取锁
         * 我先尝试获取锁，如果获取到锁我就不添加到同步队列里边，直接执行
         */
        final void lock() {

            // 尝试通过一次CAS操作来获取锁
            if (compareAndSetState(0, 1))
                setExclusiveOwnerThread(Thread.currentThread());
            else
                // 通过AQS的默认实现来获取锁
                acquire(1);
        }

        /**
         * 尝试获取锁，交给sync实现
         */
        protected final boolean tryAcquire(int acquires) {

            // 交给sync来实现，
            return nonfairTryAcquire(acquires);
        }
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
         * 尝试获取锁
         * 我获取锁时先判断是不是有节点在等待，如果有节点在等待，我只能添加到同步队列里边
         */
        protected final boolean tryAcquire(int acquires) {

            final Thread current = Thread.currentThread();
            int c = getState();

            // 如果锁未被获取则执行以下逻辑
            if (c == 0) {
                if (!hasQueuedPredecessors() && // 没有竞争或者队列为空
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

    public String toString() {
        Thread o = sync.getOwner();
        return super.toString() + ((o == null) ?
                "[Unlocked]" :
                "[Locked by thread " + o.getName() + "]");
    }
}
