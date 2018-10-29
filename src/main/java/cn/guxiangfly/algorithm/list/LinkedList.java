package cn.guxiangfly.algorithm.list;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/23/18
 * @desc : JavaHomeWork
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }


        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }


    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    public void add(int index,E e){
        if (index<0 || index>size){
            throw new IllegalArgumentException("Add failed. Illegal index");
        }
        if (index==0){
            addFirst(e);
        }else {
            Node prev = head;
            for (int i = 0; i <index-1 ; i++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next=prev.next;
            prev.next=node;

         //   prev.next = new Node(e,prev.next);
            size++;
        }

    }
}
