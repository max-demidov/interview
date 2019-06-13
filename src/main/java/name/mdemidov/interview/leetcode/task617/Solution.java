package name.mdemidov.interview.leetcode.task617;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up
 * as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) {
            return null;
        }
        if (null == t1) {
            return t2;
        }
        if (null == t2) {
            return t1;
        }
        TreeNode t = new TreeNode(t1.val + t2.val);
        if (t1.left != null || t2.left != null) {
            t.left = mergeTrees(t1.left, t2.left);
        }
        if (t1.right != null || t2.right != null) {
            t.right = mergeTrees(t1.right, t2.right);
        }
        return t;
    }
}
