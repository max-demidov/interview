package name.mdemidov.interview.leetcode.task0987;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * <p>
 * 987. Vertical Order Traversal of a Binary Tree
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions
 * (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches
 * some nodes, we report the values of the nodes in order from top to bottom (decreasing Y
 * coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the
 * value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of
 * values of nodes.
 * <p>
 * Example 1:
 * <pre>
 *       3
 *      / \
 *     9  20
 *       /  \
 *     15    7
 * </pre>
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * <p>
 * Output: [[9],[3,15],[20],[7]]
 * <p>
 * Explanation:
 * <p>
 * Without loss of generality, we can assume the root node is at position (0, 0):
 * <p>
 * Then, the node with value 9 occurs at position (-1, -1);
 * <p>
 * The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
 * <p>
 * The node with value 20 occurs at position (1, -1);
 * <p>
 * The node with value 7 occurs at position (2, -2).
 * <p>
 * Example 2:
 *
 * <pre>
 *           1
 *         /  \
 *       2     3
 *      / \   / \
 *     4  5  6  7
 * </pre>
 * <p>
 * Input: [1,2,3,4,5,6,7]
 * <p>
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * <p>
 * Explanation:
 * <p>
 * The node with value 5 and the node with value 6 have the same position according to the given
 * scheme. However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than
 * 6.
 * <p>
 * Note:
 * <p>
 * The tree will have between 1 and 1000 nodes.
 * <p>
 * Each node's value will be between 0 and 1000.
 */
public class Solution {

  private static final Solution S = new Solution();

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    Map<Integer, Map<Integer, Queue<Integer>>> map = new TreeMap<>();
    verticalTraversal(root, map, 0, 0);
    List<List<Integer>> list = new ArrayList<>();
    for (Map<Integer, Queue<Integer>> m : map.values()) {
      list.add(new ArrayList<>());
      for (Queue<Integer> queue : m.values()) {
        while (!queue.isEmpty()) {
          list.get(list.size() - 1).add(queue.poll());
        }
      }
    }
    return list;
  }

  private static void verticalTraversal(TreeNode root,
      Map<Integer, Map<Integer, Queue<Integer>>> map, int dist, int level) {
    if (root == null) {
      return;
    }

    map.putIfAbsent(dist, new TreeMap<>());
    map.get(dist).putIfAbsent(level, new PriorityQueue<>());
    map.get(dist).get(level).offer(root.val);
    verticalTraversal(root.left, map, dist - 1, level + 1);
    verticalTraversal(root.right, map, dist + 1, level + 1);
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(3);
    t1.left = new TreeNode(9);
    t1.right = new TreeNode(20);
    t1.right.left = new TreeNode(15);
    t1.right.right = new TreeNode(7);
    System.out.println(S.verticalTraversal(t1)); // [[9],[3,15],[20],[7]]

    TreeNode t2 = new TreeNode(1);
    t2.left = new TreeNode(2);
    t2.right = new TreeNode(3);
    t2.left.left = new TreeNode(4);
    t2.left.right = new TreeNode(5);
    t2.right.left = new TreeNode(6);
    t2.right.right = new TreeNode(7);
    System.out.println(S.verticalTraversal(t2)); // [[4],[2],[1,5,6],[3],[7]]

    TreeNode t3 = new TreeNode(0);
    t3.left = new TreeNode(8);
    t3.right = new TreeNode(1);
    t3.right.left = new TreeNode(3);
    t3.right.right = new TreeNode(2);
    t3.right.left.right = new TreeNode(4);
    t3.right.right.left = new TreeNode(5);
    t3.right.left.right.right = new TreeNode(7);
    t3.right.right.left.left = new TreeNode(6);
    System.out.println(S.verticalTraversal(t3)); // [[8],[0,3,6],[1,4,5],[2,7]]
  }
}
