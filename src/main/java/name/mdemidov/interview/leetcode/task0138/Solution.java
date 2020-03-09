package name.mdemidov.interview.leetcode.task0138;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * 138. Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to,
 * or null if it does not point to any node.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 * Example 4:
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so return null.
 *
 * Constraints:
 *
 * -10000 <= Node.val <= 10000
 * Node.random is null or pointing to a node in the linked list.
 * Number of Nodes will not exceed 1000.
 */
public class Solution {

    private static final Solution S = new Solution();

    private static class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return String.format("%d(%s)%s", val,
                                 random == null ? "" : random.val,
                                 next == null ? "" : "->" + next);
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node n = head;
        while (n != null) {
            map.put(n, new Node(n.val));
            n = n.next;
        }
        n = head;
        while (n != null) {
            map.get(n).next = map.get(n.next);
            map.get(n).random = map.get(n.random);
            n = n.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        n1.next = new Node(13);
        n1.next.next = new Node(11);
        n1.next.next.next = new Node(10);
        n1.next.next.next.next = new Node(1);
        n1.next.random = n1;
        n1.next.next.random = n1.next.next.next.next;
        n1.next.next.next.random = n1.next.next;
        n1.next.next.next.next.random = n1;
        System.out.println(S.copyRandomList(n1));
    }
}
