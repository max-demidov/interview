package name.mdemidov.interview.leetcode.task0141;

import name.mdemidov.interview.leetcode.object.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode input1 = new ListNode(3, 2, 0, -4);
        input1.next.next.next.next = input1.next;
        ListNode input2 = new ListNode(1, 3, 1);
        System.out.println(new Solution().hasCycle(input1));
        System.out.println(new Solution().hasCycle(input2));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
