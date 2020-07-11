package name.mdemidov.interview.leetcode.task0199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * <p>
 * 199. Binary Tree Right Side View
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the
 * nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * <p>
 * Output: [1, 3, 4]
 * <p>
 * Explanation:
 * <pre>
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * </pre>
 */
public class Solution {

  private static final Solution S = new Solution();

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int count;
    while ((count = queue.size()) > 0) {
      res.add(queue.peek().val);
      while (count-- > 0) {
        TreeNode node = queue.poll();
        if (node.right != null) {
          queue.offer(node.right);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    t1.left = new TreeNode(2);
    t1.left.right = new TreeNode(5);
    t1.right = new TreeNode(3);
    t1.right.right = new TreeNode(4);
    System.out.println(S.rightSideView(t1)); // [1, 3, 4]

    TreeNode t2 = new TreeNode(1);
    t2.left = new TreeNode(2);
    t2.left.right = new TreeNode(5);
    t2.right = new TreeNode(3);
    System.out.println(S.rightSideView(t2)); // [1, 3, 5]
  }
}
