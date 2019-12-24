package name.mdemidov.interview.leetcode.task094;

import name.mdemidov.interview.leetcode.object.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * 94. Binary Tree Inorder Traversal
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(3);
        System.out.println(new Solution().inorderTraversal(head));

        TreeNode head1 = new TreeNode(1);
        head1.left = new TreeNode(2);
        System.out.println(new Solution().inorderTraversal(head1));

        TreeNode head2 = new TreeNode(3);
        head2.left = new TreeNode(1);
        head2.left.right = new TreeNode(2);
        System.out.println(new Solution().inorderTraversal(head2));
    }

    private static List<Integer> inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res = inorderTraversal(root.left, res);
        res.add(root.val);
        res = inorderTraversal(root.right, res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }

}
