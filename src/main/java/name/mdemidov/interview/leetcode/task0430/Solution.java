package name.mdemidov.interview.leetcode.task0430;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * 430. Flatten a Multilevel Doubly Linked List
 *
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * You are given the head of the first level of the list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 *
 * The multilevel linked list in the input is as follows:
 *
 * 1---2---3---4---5---6---NULL
 *         |
 *         7---8---9---10--NULL
 *             |
 *             11--12--NULL
 *
 * After flattening the multilevel linked list it becomes:
 *
 * 1---2---3---7---8---11---12---9---10---4---5---6---NULL
 *
 * Example 2:
 *
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 * 1---2---NULL
 * |
 * 3---NULL
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        Node[] n = s.createNodes(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        n[0].next(n[1]).next(n[2]).next(n[3]).next(n[4]).next(n[5]);
        n[2].child(n[6]).next(n[7]).next(n[8]).next(n[9]);
        n[7].child(n[10]).next(n[11]);
        System.out.println(n[0]);
        System.out.println(s.flatten(n[0]));
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        if (head.child == null) {
            Node tmp = flatten(head.next);
            head.next = tmp;
            if (tmp != null) {
                tmp.prev = head;
            }
            return head;
        }
        Node tail = head.next;
        Node down = flatten(head.child);
        head.child = null;
        head.next = down;
        if (down != null) {
            down.prev = head;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = tail;
        if (tail != null) {
            tail.prev = tmp;
        }
        return head;
    }

    // Definition for a Node.
    class Node {

        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node next(Node next) {
            this.next = next;
            this.next.prev = this;
            return this.next;
        }

        public Node prev(Node prev) {
            this.prev = prev;
            this.prev.next = this;
            return this.prev;
        }

        public Node child(Node child) {
            this.child = child;
            return this.child;
        }

        @Override
        public String toString() {
            return val + (child == null ? "" : "[" + child + "]")
                   + (next == null ? "" : "--" + next);
        }
    }

    ;

    private Node[] createNodes(int[] vals) {
        Node[] n = new Node[vals.length];
        for (int i = 0; i < vals.length; i++) {
            n[i] = new Node(vals[i]);
        }
        return n;
    }

}
