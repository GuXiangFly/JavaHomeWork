package cn.guxiangfly.algorithm.list;



/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/24/18
 * @desc : JavaHomeWork
 */
public class LinkedStack<E> implements Stack<E> {

    LinkedListDummyHead<E> linkedList= new LinkedListDummyHead<E>();

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        E e = linkedList.removeFirst();
        return e;
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }
}
