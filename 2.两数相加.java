/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode result = null;
        ListNode current = null;
        while (l1 != null || l2 != null)
        {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (result == null) {
                result = current = new ListNode(sum % 10);
            } else {
                current.next = new ListNode(sum % 10);
                current = current.next;
            }
        }

        if (sum / 10 == 1)
            current.next = new ListNode(1);
        return result;
    }
}
// @lc code=end

