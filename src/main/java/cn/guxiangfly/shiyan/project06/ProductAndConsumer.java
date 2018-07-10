package cn.guxiangfly.shiyan.project06;

public class ProductAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(productor, "生产者").start();
        new Thread(consumer, "消费者").start();

    }

}