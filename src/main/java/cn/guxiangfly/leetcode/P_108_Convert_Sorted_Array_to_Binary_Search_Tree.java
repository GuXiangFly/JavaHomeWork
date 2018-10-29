package cn.guxiangfly.leetcode;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/25/18
 * @desc : JavaHomeWork
 */
public class P_108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums,0,nums.length);

    }

    public TreeNode helper(int[] nums, int left, int right){
        if (left>right) return null;
        int mid = (right-left)/2 + left;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = helper(nums,left,mid-1);
        treeNode.right = helper(nums,mid+1,right);
        return treeNode;
    }
}
