package cn.guxiangfly.juc.createThreadMethod;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 8/19/18
 * @desc : JavaHomeWork
 */
public class Demo1 extends Thread {

    public Demo1(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (!interrupted()) {
            System.out.println(getName() + "线程执行了");
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo1 d1 = new Demo1("thread 01");
        Demo1 d2 = new Demo1("thread 02");

        d1.start();
        d2.start();

        d1.interrupt();
    }
}
