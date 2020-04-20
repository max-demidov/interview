package name.mdemidov.interview.leetcode.task0234;

import name.mdemidov.interview.leetcode.object.ListNode;

/**
 * 234. Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(new ListNode(1, 1, 1)));
        System.out.println(new Solution().isPalindrome(new ListNode(1, 2, 1)));
        System.out.println(new Solution().isPalindrome(new ListNode(1, 2, 2, 1)));
        System.out.println(new Solution().isPalindrome(new ListNode(1, 2, 1, 2, 1)));
        System.out.println(new Solution().isPalindrome(new ListNode(1, 2, 1, 0, 2, 1)));
    }

    private static ListNode reverted(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            tmp.next = node;
            node = tmp;
            head = head.next;
        }
        return node;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode reverted = reverted(head);
        while (head != null) {
            if (head.val != reverted.val) {
                return false;
            }
            head = head.next;
            reverted = reverted.next;
        }
        return true;
    }
}
