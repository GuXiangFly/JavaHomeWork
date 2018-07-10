package cn.guxiangfly.waibao;

import java.util.Arrays;

/**
 * IntegerArrayQueue
 *
 * @author guxiang
 * @date 2017/12/15
 */
public class IntegerArrayQueue {

    public final  int istoragespace = 1000;
    public int low;
    public int high;

    private int storagespace;
    private  Integer[] arr;

    public IntegerArrayQueue(){
        low=high = -1;
        storagespace = istoragespace;
        arr = new Integer[storagespace];
    }

    public void enqueue (Integer value){
        if (high ==-1)low = 0;
        else if (high+1 >=storagespace){
            storagespace *=2;
            arr= Arrays.copyOf(arr,storagespace);

        }
        arr[++high] = value;
    }

    public Integer dequeue(){
        if (high==-1) return null;

        Integer res;

        if (high==low){
            high=-1;
            res = arr[low];
            low=-1;

        }
        else res = arr[low++];
        return res;
    }
}
