package name.mdemidov.interview.leetcode.task023;

import name.mdemidov.interview.leetcode.object.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 *
 * Output: 1->1->2->3->4->4->5->6
 */
public class Solution {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        System.out.println(
            new name.mdemidov.interview.leetcode.task023.Solution()
                .mergeKLists(new ListNode[]{a, b, c}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Map<Integer, Integer> values = new TreeMap<>();
        for (ListNode node : lists) {
            while (node != null) {
                int number = values.getOrDefault(node.val, 0);
                values.put(node.val, number + 1);
                node = node.next;
            }
        }

        ListNode head = null;
        ListNode last = null;
        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            int number = entry.getValue();
            while (number-- > 0) {
                if (head == null) {
                    head = new ListNode(entry.getKey());
                    last = head;
                } else {
                    last.next = new ListNode(entry.getKey());
                    last = last.next;
                }
            }
        }
        return head;
    }
}
