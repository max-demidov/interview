package name.mdemidov.interview.leetcode.task0572;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * 572. Subtree of Another Tree
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure
 * and node values with a subtree of s. A subtree of s is a tree consists of a node in s
 * and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 *
 * Given tree s:
 *     3
 *    / \
 *   4   5
 *  / \
 * 1   2
 *
 * Given tree t:
 *   4
 *  / \
 * 1   2
 *
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 * Example 2:
 *
 * Given tree s:
 *       3
 *      / \
 *     4   5
 *    / \
 *   1   2
 *      /
 *    0
 *
 * Given tree t:
 *   4
 *  / \
 * 1   2
 *
 * Return false.
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return isEqual(s, t);
        }
        return isEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(3);
        s1.left = new TreeNode(4);
        s1.left.left = new TreeNode(1);
        s1.left.right = new TreeNode(2);
        s1.right = new TreeNode(5);

        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);

        System.out.println(S.isSubtree(s1, t1));

        TreeNode s2 = new TreeNode(3);
        s2.left = new TreeNode(4);
        s2.left.left = new TreeNode(1);
        s2.left.right = new TreeNode(2);
        s2.left.right.left = new TreeNode(0);
        s2.right = new TreeNode(5);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);

        System.out.println(S.isSubtree(s2, t2));
    }
}
