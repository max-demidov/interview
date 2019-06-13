package name.mdemidov.interview.leetcode.task002;


import name.mdemidov.interview.leetcode.object.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution {

    public static void main(String[] args) {
        ListNode input1 = new ListNode(5);
//        input1.next = new ListNode(4);
//        input1.next.next = new ListNode(3);
        ListNode input2 = new ListNode(5);
//        input2.next = new ListNode(6);
//        input2.next.next = new ListNode(4);

        ListNode output = new Solution().addTwoNumbers(input1, input2);
        System.out.println(output);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int extra) {
        if (l1 == null && l2 == null && extra < 1) {
            return null;
        }
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + extra;
        ListNode res = new ListNode(sum % 10);
        res.next = addTwoNumbers((l1 == null ? null : l1.next), (l2 == null ? null : l2.next), sum / 10);
        return res;
    }
}
