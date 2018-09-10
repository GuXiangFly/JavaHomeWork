package cn.guxiangfly.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 9/3/18
 * @desc : JavaHomeWork
 */
public class MyLock implements Lock {

    public static boolean isLocked= false;

    Thread lockBy = null;

    int lockCount = 0 ;


    @Override
    public synchronized void lock() {

        Thread currentThread = Thread.currentThread();
        while (isLocked && currentThread!=lockBy){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isLocked = true;
        lockBy = currentThread;
        lockCount++;
    }
    @Override
    public void unlock() {

        if (lockBy == Thread.currentThread()){
            lockCount -- ;
            if (lockCount==0){
                notify();
                isLocked = false;
            }
        }
        isLocked = false;
        notify();
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
