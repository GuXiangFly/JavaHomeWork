package cn.guxiangfly.leetcode;

/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/25/18
 * @desc : JavaHomeWork
 */
public class P_088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[n + m];
        int m2 = 0, n2 = 0;
        int cur = 0;
        while (n2 < n && m2 < m) {
            if (nums1[m2] <= nums2[n2]) {
                num[cur] = nums1[m2];
                m2++;
            }else {
                num[cur] = nums2[n2];
                n2++;
            }
            cur++;
        }

        if (n2 == n) {
            for (int i = m2; i < m; i++) {
                num[cur] = nums1[m2];
                cur++;
            }
        }

        if (m2 == m) {
            for (int i = n2; i < n; i++) {
                num[cur] = nums2[n2];
                cur++;
            }
        }
        nums1 = num;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        new P_088_Merge_Sorted_Array().merge(nums1,m,nums2,n);
    }
}
