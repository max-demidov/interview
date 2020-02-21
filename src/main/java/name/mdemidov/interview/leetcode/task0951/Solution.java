package name.mdemidov.interview.leetcode.task0951;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 *
 * 951. Flip Equivalent Binary Trees
 *
 * For a binary tree T, we can define a flip operation as follows:
 * choose any node, and swap the left and right child subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y if and only if
 * we can make X equal to Y after some number of flip operations.
 *
 * Write a function that determines whether two binary trees are flip equivalent.
 * The trees are given by root nodes root1 and root2.
 *
 * Example 1:
 *
 * Input:
 * root1 = [1,2,3,4,5,6,null,null,null,7,8],
 * root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * Output: true
 * Explanation: We flipped at nodes with values 1, 3, and 5.
 *
 * Note:
 *
 * Each tree will have at most 100 nodes.
 * Each value in each tree will be a unique integer in the range [0, 99].
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.left.right.left = new TreeNode(7);
        t1.left.right.right = new TreeNode(8);
        t1.right = new TreeNode(3);
        t1.right.left = new TreeNode(6);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.left.right = new TreeNode(6);
        t2.right = new TreeNode(2);
        t2.right.left = new TreeNode(4);
        t2.right.right = new TreeNode(5);
        t2.right.right.left = new TreeNode(8);
        t2.right.right.right = new TreeNode(7);

        System.out.println(S.flipEquiv(t1, t2));
    }
}
