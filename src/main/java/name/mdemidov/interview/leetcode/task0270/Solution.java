package name.mdemidov.interview.leetcode.task0270;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * <p>
 * 270. Closest Binary Search Tree Value
 * <p>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is
 * closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point. You are guaranteed to have only one unique value in the
 * BST that is closest to the target.
 * <p>
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 * <pre>
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 * </pre>
 * <p>
 * Output: 4
 */
public class Solution {

  private static final Solution S = new Solution();

  public int closestValue(TreeNode root, double target) {
    int closest = root.val;
    while (root != null) {
      if (Math.abs(root.val - target) < Math.abs(closest - target)) {
        closest = root.val;
      }
      root = target < root.val ? root.left : root.right;
    }
    return closest;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(4);
    t1.left = new TreeNode(2);
    t1.left.left = new TreeNode(1);
    t1.left.right = new TreeNode(3);
    t1.right = new TreeNode(5);
    System.out.println(S.closestValue(t1, 3.7));
  }
}
