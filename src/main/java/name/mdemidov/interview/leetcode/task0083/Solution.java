package name.mdemidov.interview.leetcode.task0083;


import name.mdemidov.interview.leetcode.object.ListNode;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().deleteDuplicates(new ListNode(1, 2, 2, 2, 3, 3, 4)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
