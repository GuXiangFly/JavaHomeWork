package cn.guxiangfly.leetcode;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/24/18
 * @desc : JavaHomeWork

*/


public class P_110_Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;

        int left_height = height(root.left);
        int right_height = height(root.right);

        return (Math.abs(left_height-right_height)<=1)&& isBalanced(root.left)&&isBalanced(root.right);
    }

    int height(TreeNode node){
        if (node == null ) return 0;

        int left_height = height(node.left);
        int right_height = height(node.right);

        return  Integer.max(left_height,right_height) +1;
    }
}
