package cn.guxiangfly.waibao;

/**
 * TestQueue
 *
 * @author guxiang
 * @date 2017/12/15
 */
public class TestQueue {
    public static void main(String[] args) {
        IntegerArrayQueue qu = new IntegerArrayQueue();
        int a = 201;
        int b = 1677;
        int x = 25;
        int mod = 22133;

        qu.enqueue(-2);
        Integer g;
        for (int i = 0; i < 1200; i++) {
            qu.enqueue(x);
            g = qu.dequeue();
            x=(x*a +b + g)%mod;

            qu.dequeue();
System.out.println("");

        }
    }
}
