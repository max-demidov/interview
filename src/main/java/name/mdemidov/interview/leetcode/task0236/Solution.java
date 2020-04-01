package name.mdemidov.interview.leetcode.task0236;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a
 * node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according
 * to the LCA definition.
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 */
public class Solution {

    private static final Solution S = new Solution();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(5);
        t1.left.left = new TreeNode(6);
        t1.left.right = new TreeNode(2);
        t1.left.right.left = new TreeNode(7);
        t1.left.right.right = new TreeNode(4);
        t1.right = new TreeNode(1);
        t1.right.left = new TreeNode(0);
        t1.right.right = new TreeNode(8);

        System.out.println(S.lowestCommonAncestor(t1, new TreeNode(5), new TreeNode(1))); // 3
        System.out.println(S.lowestCommonAncestor(t1, new TreeNode(5), new TreeNode(4))); // 5
    }
}
