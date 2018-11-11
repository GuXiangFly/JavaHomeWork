package cn.guxiangfly.juc.join;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 11/6/18
 * @desc : JavaHomeWork
 */
public class ThreadJoinStudy {

    public void a(Thread joinThread){
        System.out.println("function a run begin");
        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("function a run end");
    }

    public void b(){
        System.out.println("function b run begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("function b run end");
    }

    public static void main(String[] args) {
        ThreadJoinStudy threadJoinStudy = new ThreadJoinStudy();

       Thread thread =   new Thread(()->{
            threadJoinStudy.b();
        });

        new Thread(()->{
            threadJoinStudy.a(thread);
        }).start();

        thread.start();
    }
}
