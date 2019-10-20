package name.mdemidov.interview.leetcode.task206;

import name.mdemidov.interview.leetcode.object.ListNode;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseList(new ListNode(1, 2, 3, 4, 5)));
    }

    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = node;
            node = tmp;
            head = head.next;
        }
        return node;
    }

}
