package cn.guxiangfly.juc.lock;

import sun.tools.jconsole.Plotter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 9/11/18
 * @desc : JavaHomeWork
 */
public class MyLockByAQS implements Lock {
    private Helper helper;

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        //return helper.tryAcquireNanos(1,null);
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

    private class Helper extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            //第一个线程进入 可以拿到锁  那么返回true
            // 第二个线程拿不到锁 返回false

            int state = getState();
            if (compareAndSetState(0, arg)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread()!=getExclusiveOwnerThread()){
                throw new RuntimeException();
            }
            int state = getState()-arg;
            boolean flag = false;
            if (getState()==1){
                setExclusiveOwnerThread(null);
                flag= true;
            }

            setState(state);
            return flag;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }
}
