package cn.guxiangfly.juc.condition;

import jdk.nashorn.internal.ir.IfNode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 9/21/18
 * @desc : JavaHomeWork
 */
public class ConditionProviderAndConsumer {

    private int count;

    private Lock lock = new ReentrantLock();
    Condition p = lock.newCondition();
    Condition t = lock.newCondition();

    public final int MAX_COUNT = 10;

    public void push() {
        lock.lock();
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存达到最大");
                p.await();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "当前库存为:"+ count);
        t.notify();
        lock.unlock();
    }
}

