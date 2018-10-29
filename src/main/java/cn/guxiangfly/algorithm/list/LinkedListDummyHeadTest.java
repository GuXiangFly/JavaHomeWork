package cn.guxiangfly.algorithm.list;

import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/24/18
 * @desc : JavaHomeWork
 */

public class LinkedListDummyHeadTest {
    public static void main(String[] args) {
        LinkedListDummyHead<Integer> linkedList = new LinkedListDummyHead<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }


        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);


    }

}
