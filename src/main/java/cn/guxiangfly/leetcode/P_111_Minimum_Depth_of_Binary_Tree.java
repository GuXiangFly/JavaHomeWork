package cn.guxiangfly.leetcode;

import cn.guxiangfly.jueceshu.test2.Node;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/24/18
 * @desc : JavaHomeWork
 */
public class P_111_Minimum_Depth_of_Binary_Tree {


    public int minDepth(TreeNode root) {
        if (root==null) return 0;

        int left_height = minDepth(root.left);
        int right_height = minDepth(root.right);

        if(root.left==null && root.right!=null){
            return right_height+1;
        }
        if(root.right==null && root.left!=null){
            return left_height+1;
        }
        return  Integer.min(left_height,right_height) +1;
    }


}
