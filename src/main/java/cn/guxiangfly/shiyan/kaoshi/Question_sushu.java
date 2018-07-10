package cn.guxiangfly.shiyan.kaoshi;

/**
 * Question_sushu
 *
 * @author guxiang
 * @date 2018/1/1
 */
public class Question_sushu {
    private Integer mutex = 1;
    public static Integer num =0;
    public static void main(String[] args) {
        Question_sushu pn = new Question_sushu();
        Thread1 t1 = new Thread1(2, 1000);
        Thread1 t2 = new Thread1(1000, 2000);
        Thread1 t3 = new Thread1(2000, 3000);

        t1.start();
        t2.start();
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("共有"+num+"个素数");
    }
}


class Thread1 extends Thread {
    private int start;
    private int end;

    public Thread1(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start+1; i <end ; i++) {
            synchronized (Question_sushu.class) {
                int flag = 1;
                for (int j = 2; j < Math.ceil(Math.sqrt(i)); j++) {
                    if (i%j==0){
                        flag=0;
                    }
                }
                if (flag==1){
                    Question_sushu.num++;
                }
            }

        }
    }
}