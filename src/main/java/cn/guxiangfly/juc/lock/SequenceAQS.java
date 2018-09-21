package cn.guxiangfly.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 8/31/18
 * @desc : JavaHomeWork
 */
public class SequenceAQS {

    private int value;


    public int getNext() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value++;
    }

    public synchronized int getNext2() {
        int a = value++;
        return a;
    }

    public static void main(String[] args) {
        SequenceAQS sequenceAQS = new SequenceAQS();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.err.println(Thread.currentThread().getId() + " " + sequenceAQS.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.err.println(Thread.currentThread().getId() + " " + sequenceAQS.getNext());
                }
            }
        }).start();
    }
}
