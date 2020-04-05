package name.mdemidov.interview.leetcode.task0105;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 * 3
 * /  \
 * 9   20
 * /  \
 * 15    7
 */
public class Solution {

    private static final Solution S = new Solution();
    private int inIndex = 0;
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int byValue) {
        if (preIndex >= preorder.length) {
            return null;
        }
        if (inorder[inIndex] == byValue) {
            inIndex++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex++]);
        node.left = buildTree(preorder, inorder, node.val);
        node.right = buildTree(preorder, inorder, byValue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        System.out.println(t1);
        System.out.println(S.buildTree(new int[]{3, 9, 20, 15, 7},
                                       new int[]{9, 3, 15, 20, 7}));
    }
}