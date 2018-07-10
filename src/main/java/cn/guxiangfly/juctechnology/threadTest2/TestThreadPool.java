package cn.guxiangfly.juctechnology.threadTest2;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * TestThreadPool
 *
 * @author guxiang
 * @date 2018/1/22
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();


        for (int i = 0; i < 5; i++) {
            pool.submit(threadPoolDemo);
        }
        //new Thread(threadPoolDemo).start();
        pool.shutdown();

    }

    @Test
    public  void test1() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);


        Callable<Integer> callable;

        Future<Integer> submit = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            }
        });


        System.out.println(submit.get());

        pool.shutdown();
    }


    @Test
    public  void test2() throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);


        for (int i = 0; i < 5; i++) {
            Future<Integer> schedule = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }
                    return sum;
                }
            },1,TimeUnit.SECONDS);
            System.out.println(schedule.get());
        }

        pool.shutdown();
    }
}


class ThreadPoolDemo implements Runnable{

    private int i=0;

    @Override
    public void run() {
        while (i<=10000){
            System.out.println(Thread.currentThread().getName()+" : "+ i++);
        }
    }
}
