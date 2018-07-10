package cn.guxiangfly.java8.stream;

/**
 * TestStreamAPI1
 *
 * @author guxiang
 * @date 2018/2/7
 */



import org.junit.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 一、 Stream 的操作步骤
 *
 * 1. 创建 Stream
 *
 * 2. 中间操作
 *
 * 3. 终止操作
 */
public class TestStreamAPI1 {

    @Test
    public void  test1() {

        // 创建stream的三种方式
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();


        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //创建无限流的第二种  generate
        Stream<Double> stream5 = Stream.generate(()->Math.random());
        stream5.limit(5).forEach(System.out::println);

        Consumer<Integer> consumer = (x)->System.out.println(x);
        consumer.accept(10);


    }
}
