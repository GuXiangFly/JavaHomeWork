package cn.guxiangfly.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 7/30/18
 * @desc : JavaHomeWork
 */
public abstract class CountDownLatchAdapter {

    public static  void countDownLatchProcess(List searchList, List  resultList , Function<Object,ArrayList> function){
        final CountDownLatch countDownLatch = new CountDownLatch(searchList.size());

        for (Object o : searchList) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    synchronized (this) {
                        try {
                            ArrayList apply = function.apply(o);
                            resultList.addAll(apply);
                        } finally {
                            countDownLatch.countDown();
                        }
                    }
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        List<String> searchList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();

        searchList.add("A");
        searchList.add("B");
        searchList.add("C");
        searchList.add("D");

        CountDownLatchAdapter.countDownLatchProcess(searchList, resultList, new Function<Object, ArrayList>() {
            @Override
            public ArrayList apply(Object o) {
                ArrayList<Object> result = new ArrayList<>();
                result.add(o.toString()+"---");
                result.add(o.toString()+"---");
                result.add(o.toString()+"---");
                return result;
            }
        });

        for (String s : resultList) {
            System.err.println(s);
        }
    }

}

