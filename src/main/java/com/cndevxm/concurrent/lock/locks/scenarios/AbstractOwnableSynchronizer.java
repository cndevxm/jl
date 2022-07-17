package com.cndevxm.concurrent.lock.locks.scenarios;

/**
 * 独占模式相关接口
 */
public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {

    /**
     * Use serial ID even though all fields transient.
     */
    private static final long serialVersionUID = 3737899427754241961L;

    /**
     * Empty constructor for use by subclasses.
     */
    protected AbstractOwnableSynchronizer() {
    }

    /**
     * 独占锁的线程
     */
    private transient Thread exclusiveOwnerThread;

    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }
}
