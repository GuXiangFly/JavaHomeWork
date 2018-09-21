package cn.guxiangfly.juc.condition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 9/20/18
 * @desc : JavaHomeWork
 */
public class ConditionDemo {

    private  int signal = 0;

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void a() {
        lock.lock();
        if (signal != 0) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.err.println("a");
        signal++;
        b.signal();

        lock.unlock();
    }

    public void b() {
        lock.lock();
        if (signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.err.println("b");
        signal++;
        c.signal();

        lock.unlock();
    }

    public void c() {
        lock.lock();
        if (signal != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.err.println("c");
        signal=0;
        a.signal();

        lock.unlock();
    }

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    conditionDemo.a();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    conditionDemo.b();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    conditionDemo.c();
                }
            }
        }).start();
    }
}
