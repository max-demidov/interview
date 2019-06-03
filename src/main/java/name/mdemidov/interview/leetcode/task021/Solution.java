package name.mdemidov.interview.leetcode.task021;

import name.mdemidov.interview.leetcode.object.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode input1 = new ListNode(1);
        input1.next = new ListNode(2);
        input1.next.next = new ListNode(4);

        ListNode input2 = new ListNode(1);
        input2.next = new ListNode(3);
        input2.next.next = new ListNode(4);

        ListNode output = new Solution().mergeTwoLists(input1, input2);
        System.out.println(output);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
