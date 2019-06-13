package name.mdemidov.interview.leetcode.task100;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(1);
        input1.left = new TreeNode(2);
        input1.right = new TreeNode(4);

        TreeNode input2 = new TreeNode(1);
        input2.left = new TreeNode(2);
        input2.right = new TreeNode(4);

        boolean output = new Solution().isSameTree(input1, input2);
        System.out.println(output);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
