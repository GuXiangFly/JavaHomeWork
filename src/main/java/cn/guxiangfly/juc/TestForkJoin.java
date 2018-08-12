package cn.guxiangfly.juc;

import javafx.geometry.VPos;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    @Test
    public void test1() {
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0, 10000000000L);  //2650
        Long sum = forkJoinPool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());

    }

    @Test
    public void test2() {
        Instant start = Instant.now();
        Long sum = 0L;
        for (long i = 0; i < 10000000000L; i++) { //31099
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }

    @Test
    public void test3() {
        Instant start = Instant.now();

        LongStream.rangeClosed(0,10000000000L)   //1550
                .parallel()
                .reduce(0,Long::sum);

        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
    }
}