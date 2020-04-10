package name.mdemidov.interview.leetcode.task0148;

import name.mdemidov.interview.leetcode.object.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 *
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class Solution {

    private static final Solution S = new Solution();

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        return merge(l, r);
    }

    private static ListNode merge(ListNode l, ListNode r) {
        ListNode res = new ListNode(0);
        ListNode cur = res;

        while (l != null && r != null) {
            if (l.val < r.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = r;
                r = r.next;
            }
            cur = cur.next;
        }

        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(1);
        n1.next.next.next = new ListNode(3);
        System.out.println(S.sortList(n1)); // 1->2->3->4

        ListNode n2 = new ListNode(-1);
        n2.next = new ListNode(5);
        n2.next.next = new ListNode(3);
        n2.next.next.next = new ListNode(4);
        n2.next.next.next.next = new ListNode(0);
        System.out.println(S.sortList(n2)); // -1->0->3->4->5
    }
}
