package name.mdemidov.interview.leetcode.task019;

import name.mdemidov.interview.leetcode.object.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class Solution {

    private static final ListNode NODE1 = new ListNode(1);
    private static final ListNode NODE2 = new ListNode(2);
    private static final ListNode NODE3 = new ListNode(3);
    private static final ListNode NODE4 = new ListNode(4);
    private static final ListNode NODE5 = new ListNode(5);

    static {
        NODE1.next = NODE2;
        NODE2.next = NODE3;
        NODE3.next = NODE4;
        NODE4.next = NODE5;
    }

    public static void main(String[] args) {
        System.out.println(
            new name.mdemidov.interview.leetcode.task019.Solution().removeNthFromEnd(NODE1, 5)
        );
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        append(list, head);
        Collections.reverse(list);
        if (n == list.size()) {
            return head.next;
        }
        if (n - 2 < 0) {
            list.get(n).next = null;
        } else {
            list.get(n).next = list.get(n - 2);
        }
        return head;
    }

    private void append(List<ListNode> list, ListNode head) {
        if (head == null) {
            return;
        }
        list.add(head);
        append(list, head.next);
    }
}
