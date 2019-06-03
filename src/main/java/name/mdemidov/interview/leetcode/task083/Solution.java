package name.mdemidov.interview.leetcode.task083;


import name.mdemidov.interview.leetcode.object.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode input = new ListNode(1);
        input.next = new ListNode(2);
        input.next.next = new ListNode(2);
        input.next.next.next = new ListNode(2);
        input.next.next.next.next = new ListNode(3);
        input.next.next.next.next.next = new ListNode(3);
        input.next.next.next.next.next.next = new ListNode(4);

        ListNode output = new Solution().deleteDuplicates(input);
        System.out.println(output);
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
