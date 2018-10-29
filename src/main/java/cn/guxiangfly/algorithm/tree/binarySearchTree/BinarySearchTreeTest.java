package cn.guxiangfly.algorithm.tree.binarySearchTree;



import jdk.nashorn.internal.ir.IfNode;

import static org.junit.Assert.*;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/7/18
 * @desc : JavaHomeWork
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        int[] nums = {5,3,6,8,4,2};
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int num : nums) {
            binarySearchTree.add(num);
        }
        binarySearchTree.preOrder();

        binarySearchTree.inOrder();
        System.out.println();
        System.out.println(binarySearchTree.toString());
    }

}
