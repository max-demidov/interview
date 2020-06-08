package name.mdemidov.interview.leetcode.task0938;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * <p>
 * 938. Range Sum of BST
 * <p>
 * Given the root node of a binary search tree, return the sum of values of all nodes with value
 * between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 Output: 32
 * <p>
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10 Output: 23
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * <p>
 * The final answer is guaranteed to be less than 2^31.
 */
public class Solution {

  private static final Solution S = new Solution();

  public int rangeSumBST(TreeNode root, int L, int R) {
    if (root == null) {
      return 0;
    }
    return (L <= root.val && root.val <= R ? root.val : 0)
        + rangeSumBST(root.left, L, R)
        + rangeSumBST(root.right, L, R);
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(10);
    t1.left = new TreeNode(5);
    t1.right = new TreeNode(15);
    t1.left.left = new TreeNode(3);
    t1.left.right = new TreeNode(7);
    t1.right.right = new TreeNode(18);
    System.out.println(S.rangeSumBST(t1, 7, 15)); // 32

    TreeNode t2 = new TreeNode(10);
    t2.left = new TreeNode(5);
    t2.right = new TreeNode(15);
    t2.left.left = new TreeNode(3);
    t2.left.right = new TreeNode(7);
    t2.right.left = new TreeNode(13);
    t2.right.right = new TreeNode(18);
    t2.left.left.left = new TreeNode(1);
    t2.left.right.left = new TreeNode(6);
    System.out.println(S.rangeSumBST(t2, 6, 10)); // 23
  }
}
