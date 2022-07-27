package com.cndevxm.concurrent.sourceAnalyize.locks;

/**
 * 独占模式抽象类
 * 作用：set与get独占线程
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
