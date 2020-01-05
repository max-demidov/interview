package name.mdemidov.interview.leetcode.task0222;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * 222. Count Complete Tree Nodes
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *      1
 *    /  \
 *   2    3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        System.out.println(new Solution().countNodes(node));
        node.left = new TreeNode(2);
        System.out.println(new Solution().countNodes(node));
        node.right = new TreeNode(3);
        System.out.println(new Solution().countNodes(node));
        node.left.left = new TreeNode(4);
        System.out.println(new Solution().countNodes(node));
        node.left.right = new TreeNode(5);
        System.out.println(new Solution().countNodes(node));
        node.right.left = new TreeNode(6);
        System.out.println(new Solution().countNodes(node));
    }

    private static int countNodes(TreeNode root, int base) {
        if (root == null) {
            return base;
        }
        return 1 + countNodes(root.left, base) + countNodes(root.right, base);
    }

    public int countNodes(TreeNode root) {
        return countNodes(root, 0);
    }

}
