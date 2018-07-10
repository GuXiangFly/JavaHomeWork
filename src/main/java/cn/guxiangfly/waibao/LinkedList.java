package cn.guxiangfly.waibao;

import com.example.jctree.TreeNode;

/**
 * LinkedList
 *
 * @author guxiang
 * @date 2017/12/15
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList(){
        head = tail = null;
    }




    private class  Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    public void appendLeft(T value){
        head = new Node<>(value,head);

        if (head.next ==null) tail=head;
    }

    public T popRight(){
        if (tail==null){
            return null;
        }

        if (head==tail) {
            T res = head.value;
            head = tail = null;

            return res;
        }

        Node<T> cur = head;

        while (cur.next !=tail)
            cur = cur.next;
        tail=cur;
        return tail.next.value;

    }






}
