package cn.guxiangfly.leetcode;



/**
 * @author: xianggu@ebay.com
 * @date : 2018 10/24/18
 * @desc : JavaHomeWork
 */

class ListNode {
    int val = 0;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class P_021_MeregeTwoSortedList {


    public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;

        while (l1 != null && l2!=null){
            if (l1.val < l2.val){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                cur.next = new ListNode(l2.val);
                l2=l2.next;
            }
            cur = cur.next;
        }

        if (l1 !=null){
            cur.next = l1;
        }else {
            cur.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
