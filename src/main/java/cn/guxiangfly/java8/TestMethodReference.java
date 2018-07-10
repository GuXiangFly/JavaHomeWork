package cn.guxiangfly.java8;



import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * TestMethodReference
 *
 * @author guxiang
 * @date 2018/7/2
 */
public class TestMethodReference {

    public static void main(String[] args) {
        PrintStream ps =System.out;
        Consumer<String> consumer = (x)->ps.println(x);
        consumer.accept("1112");
        // 等价于
        Consumer<String> consumer2 = ps::println;
        consumer2.accept("2222");

        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);

    }
}
