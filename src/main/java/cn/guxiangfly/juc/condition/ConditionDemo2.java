package cn.guxiangfly.juc.condition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 9/20/18
 * @desc : JavaHomeWork
 */
public class ConditionDemo2 {

    private  int signal = 0;

    Lock lock = new ReentrantLock();
    Condition a = lock.newCondition();
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void a() {
        lock.lock();
        System.err.println("a");
        lock.unlock();
    }

    public void b() {
        lock.lock();

        System.err.println("b");

        lock.unlock();
    }

    public void c() {
        lock.lock();

        System.err.println("c");

        lock.unlock();
    }


    public static void main(String[] args) {
        ConditionDemo2 conditionDemo = new ConditionDemo2();

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
