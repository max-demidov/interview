package name.mdemidov.interview.leetcode.task0889;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 *
 * Return any binary tree that matches the given preorder and postorder traversals.
 *
 * Values in the traversals pre and post are distinct positive integers.
 *
 * Example 1:
 *
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 *
 * Note:
 *
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class Solution {

    private static final Solution S = new Solution();

    private int preIndex = 0;
    private int postIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[postIndex]) {
            root.left = constructFromPrePost(pre, post);
        }
        if (root.val != post[postIndex]) {
            root.right = constructFromPrePost(pre, post);
        }
        postIndex++;
        return root;
    }

    public static void main(String[] args) {
        System.out.println(
            S.constructFromPrePost(
                new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1}
            )
        );
    }
}
