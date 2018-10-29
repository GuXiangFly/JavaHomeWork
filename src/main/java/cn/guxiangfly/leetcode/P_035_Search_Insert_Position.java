package cn.guxiangfly.leetcode;

import cn.guxiangfly.shiyan.kaoshi.Milk;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/25/18
 * @desc : JavaHomeWork
 */
public class P_035_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) end = mid;
            else start = mid;
        }

        if (target <= nums[start])
            return start;
        else if (target <= nums[end]) {
            return end;
        } else {
            return end+1;
        }
    }

}
