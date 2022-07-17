package com.cndevxm.concurrent.lock.locks.scenarios;

import sun.misc.Unsafe;

/**
 * Lock工具类，用于线程挂起与唤醒，支持三种方式挂起
 * 1、直接挂起
 * 2、挂起至一段时间自动唤醒
 * 3、挂起至指定时间自动唤醒
 */
public class LockSupport {

    private LockSupport() {
    }

    /**
     * 设置线程挂起信息
     */
    private static void setBlocker(Thread t, Object arg) {
        UNSAFE.putObject(t, parkBlockerOffset, arg);
    }

    /**
     * 获取线程挂起信息
     */
    public static Object getBlocker(Thread t) {
        if (t == null)
            throw new NullPointerException();
        return UNSAFE.getObjectVolatile(t, parkBlockerOffset);
    }

    /**
     * 唤醒线程
     */
    public static void unpark(Thread thread) {
        if (thread != null)
            UNSAFE.unpark(thread);
    }

    /**
     * 挂起线程，挂起时可被线程中断打断
     * 1、设置当前线程挂起信息
     * 2、设置当前线程无限期挂起
     * 3、当线程被唤醒时删除挂起信息
     */
    public static void park(Object blocker) {
        Thread t = Thread.currentThread();
        setBlocker(t, blocker);
        UNSAFE.park(false, 0L);
        setBlocker(t, null);
    }

    /**
     * 挂起线程一段时间，挂起时可被线程中断打断
     * 1、设置当前线程挂起信息
     * 2、设置当前线程有限期挂起
     * 3、当线程被唤醒时删除挂起信息
     */
    public static void parkNanos(Object blocker, long nanos) {
        if (nanos > 0) {
            Thread t = Thread.currentThread();
            setBlocker(t, blocker);
            UNSAFE.park(false, nanos);
            setBlocker(t, null);
        }
    }

    /**
     * 挂起线程到指定时间，挂起时可被线程中断打断
     * 1、设置当前线程挂起信息
     * 2、设置当前线程有限期挂起
     * 3、当线程被唤醒时删除挂起信息
     */
    public static void parkUntil(Object blocker, long deadline) {
        Thread t = Thread.currentThread();
        setBlocker(t, blocker);
        UNSAFE.park(true, deadline);
        setBlocker(t, null);
    }

    /**
     * 不设置挂起信息立即挂起线程，挂起时可被线程中断打断
     */
    public static void park() {
        UNSAFE.park(false, 0L);
    }

    /**
     * 不设置挂起信息立即挂起线程一段时间，挂起时可被线程中断打断
     */
    public static void parkNanos(long nanos) {
        if (nanos > 0)
            UNSAFE.park(false, nanos);
    }

    /**
     * 不设置挂起信息立即挂起线程到指定时间，挂起时可被线程中断打断
     */
    public static void parkUntil(long deadline) {
        UNSAFE.park(true, deadline);
    }

    /**
     * 获取线程随机数种子
     */
    static final int nextSecondarySeed() {
        int r;
        Thread t = Thread.currentThread();
        if ((r = UNSAFE.getInt(t, SECONDARY)) != 0) {
            r ^= r << 13;   // xorshift
            r ^= r >>> 17;
            r ^= r << 5;
        } else if ((r = java.util.concurrent.ThreadLocalRandom.current().nextInt()) == 0)
            r = 1; // avoid zero
        UNSAFE.putInt(t, SECONDARY, r);
        return r;
    }

    // 内存偏移量
    private static final Unsafe UNSAFE;
    private static final long parkBlockerOffset;
    private static final long SEED;
    private static final long PROBE;
    private static final long SECONDARY;

    /**
     * 设置内存偏移量
     */
    static {
        try {
            UNSAFE = Unsafe.getUnsafe();
            Class<?> tk = Thread.class;
            parkBlockerOffset = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("parkBlocker"));
            SEED = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomSeed"));
            PROBE = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomProbe"));
            SECONDARY = UNSAFE.objectFieldOffset
                    (tk.getDeclaredField("threadLocalRandomSecondarySeed"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
