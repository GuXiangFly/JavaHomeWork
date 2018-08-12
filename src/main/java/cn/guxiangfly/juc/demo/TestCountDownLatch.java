package cn.guxiangfly.juc.demo;

import com.sun.xml.bind.v2.model.core.ID;

import java.util.concurrent.CountDownLatch;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 7/30/18
 * @desc : JavaHomeWork
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);

        LatchDown latchDown = new LatchDown(latch);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            new Thread(latchDown).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时为：" + (end - start));
    }

}


class LatchDown implements Runnable {
    private CountDownLatch countDownLatch;

    public LatchDown(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 500; i++) {
                    System.out.println(i);
                }
            } finally {
                countDownLatch.countDown();
            }

        }
    }
}