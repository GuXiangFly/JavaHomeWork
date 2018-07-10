package cn.guxiangfly.java8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TestCalendarClass
 *
 * @author guxiang
 * @date 2017/11/23
 */
public class TestCalendarClass {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> callable = ()->{
           return simpleDateFormat.parse("20170823");
        };
        ExecutorService pool = Executors.newFixedThreadPool(10);
    }
}
