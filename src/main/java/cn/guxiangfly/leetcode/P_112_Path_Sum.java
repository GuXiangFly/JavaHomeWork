package cn.guxiangfly.leetcode;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/25/18
 * @desc : JavaHomeWork
 */
public class P_112_Path_Sum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root== null) return false;
        if (root.left==null&&root.right==null){
            return root.val == sum;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
}
