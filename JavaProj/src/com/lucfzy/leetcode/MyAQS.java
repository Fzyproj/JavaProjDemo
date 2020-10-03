package com.lucfzy.leetcode;



import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAQS extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        return compareAndSetState(0,1);
    }

    @Override
    protected boolean tryRelease(int arg) {
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }

    Sync sync = new Sync() {
        @Override
        public void acquire() throws InterruptedException {
            tryAcquire(1);
        }

        @Override
        public boolean attempt(long msecs) throws InterruptedException {
            return false;
        }

        @Override
        public void release() {
            tryRelease(1);
        }
    };

    public void lock() throws InterruptedException {
        sync.acquire();
    }
    public void unlock() {
        sync.release();
    }

}
