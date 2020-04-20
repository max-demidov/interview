package name.mdemidov.interview.leetcode.task0160;

import name.mdemidov.interview.leetcode.object.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Notes:
 *
 * - If the two linked lists have no intersection at all, return null.
 * - The linked lists must retain their original structure after the function returns.
 * - You may assume there are no cycles anywhere in the entire linked structure.
 * - Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class Solution {

    public static void main(String[] args) {
        ListNode intersection = new ListNode(8, 4, 5);
        ListNode a = new ListNode(4, 1).append(intersection);
        ListNode b = new ListNode(5, 0, 1).append(intersection);
        System.out.println(new Solution().getIntersectionNode(a, b));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int aSize = size(a);
        int bSize = size(b);
        a = sublist(a, aSize - bSize);
        b = sublist(b, bSize - aSize);
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private int size(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    private ListNode sublist(ListNode node, int startIndex) {
        for (int i = 0; i < startIndex; i++) {
            node = node.next;
        }
        return node;
    }

}
