package cn.guxiangfly.algorithm.list;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/23/18
 * @desc : JavaHomeWork
 */
public class LinkedListDummyHead<E> {
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

    private Node dummyHead;
    private int size;

    public LinkedListDummyHead() {
        this.dummyHead = new Node(null,null);
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
       add(0,e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

        //   prev.next = new Node(e,prev.next);
        size++;
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e){
        add(size, e);
    }

    public E get(int index){

        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        //这个表示  index为0的指针
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }


    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    public boolean contains(E e){
        //这个表示  index为0的指针
        Node cur = dummyHead.next;

        while (cur!=null){
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
      /*  for (int i = 0; i < size-1; i++) {
            if (cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }*/
        return false;

    }


    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev=prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

}