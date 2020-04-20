package name.mdemidov.interview.leetcode.task0098;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * 98. Validate Binary Search Tree
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 * 2
 * / \
 * 1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        System.out.println(new Solution().isValidBST(tree1));

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(4);
        tree2.right.left = new TreeNode(3);
        tree2.right.right = new TreeNode(6);
        System.out.println(new Solution().isValidBST(tree2));

        TreeNode tree3 = new TreeNode(10);
        tree3.left = new TreeNode(5);
        tree3.right = new TreeNode(15);
        tree3.right.left = new TreeNode(6);
        tree3.right.right = new TreeNode(20);
        System.out.println(new Solution().isValidBST(tree3));

        //        3
        //       / \
        //     1    5
        //    / \  / \
        //   0  2 4   6
        //       \
        //        3
        TreeNode tree4 = new TreeNode(3);
        tree4.left = new TreeNode(1);
        tree4.right = new TreeNode(5);
        tree4.left.left = new TreeNode(0);
        tree4.left.right = new TreeNode(2);
        tree4.right.left = new TreeNode(4);
        tree4.right.right = new TreeNode(6);
        tree4.left.right.right = new TreeNode(3);
        System.out.println(new Solution().isValidBST(tree4));

        TreeNode tree5 = new TreeNode(0);
        tree5.right = new TreeNode(1);
        System.out.println(new Solution().isValidBST(tree5));
    }

    private static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

}
