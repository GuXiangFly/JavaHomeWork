package cn.guxiangfly.leetcode;

import java.util.*;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/24/18
 * @desc : JavaHomeWork
 */


public class P_347_Top_K_Frequent_Element{

    class Freq implements Comparable<Freq>{
        public int data;
        public int count;

        public Freq(int data, int count) {
            this.data = data;
            this.count = count;
        }

        /**
         *  java中 返回的是1 代表 当前元素 比传入的元素要大
         * @param o
         * @return
         */
        @Override
        public int compareTo(Freq o) {
            if (this.count>=o.count){
                return 1;
            }else {
                return -1;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int num : nums) {
            if (treeMap.containsKey(num)){
                int freq = treeMap.get(num) + 1;
                treeMap.put(num,freq);
            }else {
                treeMap.put(num,0);
            }
        }


        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : treeMap.entrySet()) {
            priorityQueue.add(new Freq(integerIntegerEntry.getKey(),integerIntegerEntry.getValue()));
        }

        /**
         *   java内置的是最小堆， 于是我们需要将频率低的设置为优先级也低， 这样 最小堆会每次取出优先级最低的，也就是频率最低的
         */
        while (priorityQueue.size()>k){
            priorityQueue.remove(priorityQueue.peek());
        }
        List<Integer> objects = new ArrayList<>();
        while (priorityQueue.size()!=0)
        objects.add(priorityQueue.poll().data);
        return objects;
    }
}