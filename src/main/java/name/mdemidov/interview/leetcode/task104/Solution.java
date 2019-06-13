package name.mdemidov.interview.leetcode.task104;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode t, int depth) {
        if (t == null) {
            return depth;
        }
        if (t.left == null && t.right == null) {
            return depth + 1;
        }
        int leftDepth = maxDepth(t.left, depth + 1);
        int rightDepth = maxDepth(t.right, depth + 1);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}
