package name.mdemidov.interview.leetcode.task0543;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * <p>
 * 543. Diameter of Binary Tree
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of
 * a binary tree is the length of the longest path between any two nodes in a tree. This path may or
 * may not pass through the root.
 * <p>
 * Example:
 * <p>
 * Given a binary tree
 * <pre>
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * </pre>
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Solution {

  private static final Solution S = new Solution();

  public int diameterOfBinaryTree(TreeNode root) {
    return root == null ? 0 : Math.max(
        depth(root.left) + depth(root.right),
        Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
  }

  private static int depth(TreeNode root) {
    return root == null ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.left.left = new TreeNode(4);
    t1.left.right = new TreeNode(5);
    t1.right = new TreeNode(3);
    System.out.println(S.diameterOfBinaryTree(t1)); // 3
    System.out.println(S.diameterOfBinaryTree(t1.left)); // 2

    TreeNode t2 = new TreeNode(1);
    t2.right = new TreeNode(2);
    System.out.println(S.diameterOfBinaryTree(t2)); // 1

    TreeNode t3 = new TreeNode(1);
    t3.left = new TreeNode(2);
    t3.right = new TreeNode(3);
    t3.right.left = new TreeNode(4);
    t3.right.left.left = new TreeNode(5);
    t3.right.right = new TreeNode(6);
    t3.right.right.right = new TreeNode(7);
    System.out.println(S.diameterOfBinaryTree(t3));
  }
}
