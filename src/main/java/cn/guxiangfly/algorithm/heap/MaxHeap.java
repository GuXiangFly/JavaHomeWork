package cn.guxiangfly.algorithm.heap;

import cn.guxiangfly.algorithm.dynamicArray.DymaicArrayGenericity;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/29/18
 * @desc : JavaHomeWork
 */
public class MaxHeap<E extends Comparable<E>> {
    private DymaicArrayGenericity<E> data = null;

    public MaxHeap(int capacity) {
        data = new DymaicArrayGenericity(capacity);
    }

    public MaxHeap() {
        data = new DymaicArrayGenericity();
    }

    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }


    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    public int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    public E findMax(){
        if(data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private void siftDown(int k){
        int maxChildIndex = 0;
        if (data.get(leftChild(k)).compareTo(data.get(rightChild(k)))<=0){
            maxChildIndex = rightChild(k);
        }else {
            maxChildIndex = leftChild(k);
        }

        while (k>0 && data.get(maxChildIndex).compareTo(data.get(k))<0){
            siftDown(maxChildIndex);
        }
    }
    private E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
}
