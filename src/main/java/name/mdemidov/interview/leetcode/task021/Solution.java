package name.mdemidov.interview.leetcode.task021;

import name.mdemidov.interview.leetcode.object.ListNode;

public class Solution {

    public static void main(String[] args) {

        System.out.println(
            new Solution().mergeTwoLists(new ListNode(1, 2, 4), new ListNode(1, 3, 4)));
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
