package name.mdemidov.interview.leetcode.task0230;

import name.mdemidov.interview.leetcode.object.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * 230. Kth Smallest Element in a BST
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *       \
 *        2
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 * Output: 3
 *
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth
 * smallest frequently? How would you optimize the kthSmallest routine?
 */
public class Solution {

    private static final Solution S = new Solution();

    public int kthSmallest(TreeNode root, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        parse(root, deque);
        //System.out.println(deque);
        while (--k > 0) {
            deque.pollFirst();
        }
        return deque.pollFirst();
    }

    public void parse(TreeNode root, Deque<Integer> deque) {
        if (root == null) {
            return;
        }
        parse(root.left, deque);
        deque.offer(root.val);
        parse(root.right, deque);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);
        t1.right = new TreeNode(4);
        System.out.println(S.kthSmallest(t1, 1)); // 1

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(3);
        t2.left.left = new TreeNode(2);
        t2.left.left.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(6);
        System.out.println(S.kthSmallest(t2, 3)); // 3
    }
}
