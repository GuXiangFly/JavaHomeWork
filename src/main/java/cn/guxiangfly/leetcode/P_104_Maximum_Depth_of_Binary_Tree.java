package cn.guxiangfly.leetcode;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/24/18
 * @desc : JavaHomeWork
 */
public class P_104_Maximum_Depth_of_Binary_Tree {


    public int maxDepth(TreeNode root) {
        if (root==null) return 0;

        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);

        return  Integer.max(left_height,right_height) +1;
    }


}
