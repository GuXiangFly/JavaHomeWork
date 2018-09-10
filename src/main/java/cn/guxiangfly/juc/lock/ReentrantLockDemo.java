package cn.guxiangfly.juc.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 8/30/18
 * @desc : JavaHomeWork
 * 多个线程访问一个synchronized  方法，多个线程需要竞争一把锁，用这把锁来访问我们的方法，
 * 一个线程拿到这把锁后，其他线程就无法访问这个方法了
 *
 *
 * 锁重入的意思：
 * 	方法a  和 方法b   都使用 对象M 来锁，方法a中调用了方法b ， 那么线程是不需要竞争b上的锁，直接可以访问b方法的，这就会造成 锁重入，
 *
 * 重入锁的意思：
 * 	 能产生 锁重入 事件的锁 就是 重入锁    synchronized  就是重入锁
 */
public class ReentrantLockDemo {

    public synchronized void a (){
        System.err.println("a----");
        b();
    }


    public synchronized void b (){
        System.err.println("b----");
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
                reentrantLockDemo.a();
            }
        }).start();
    }
}
