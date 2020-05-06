package name.mdemidov.interview.leetcode.task0297;

import java.util.LinkedList;
import java.util.Queue;
import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 297. Serialize and Deserialize Binary Tree
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary
 * tree can be serialized to a string and this string can be deserialized to the original tree
 * structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <pre>
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * </pre>
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * <p>
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different
 * approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and
 * deserialize algorithms should be stateless.
 */
public class Codec {

  private static final Codec CODEC = new Codec();

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(root.val);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root.left);
    queue.add(root.right);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      sb.append(',');
      if (node == null) {
        continue;
      }
      sb.append(node.val);
      queue.offer(node.left);
      queue.offer(node.right);
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    String[] values = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    for (int i = 1; i < values.length; i += 2) {
      TreeNode node = queue.poll();
      String l = values[i];
      String r = i < values.length - 1 ? values[i + 1] : "";
      if (!l.isEmpty()) {
        node.left = new TreeNode(Integer.parseInt(l));
        queue.offer(node.left);
      }
      if (!r.isEmpty()) {
        node.right = new TreeNode(Integer.parseInt(r));
        queue.offer(node.right);
      }
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode t1 = CODEC.deserialize("1,2,3,,,4,5");
    System.out.println(CODEC.serialize(t1));

    TreeNode t2 = new TreeNode(1);
    t2.left = new TreeNode(2);
    t2.right = new TreeNode(3);
    t2.right.left = new TreeNode(4);
    t2.right.right = new TreeNode(5);
    System.out.println(CODEC.serialize(t2));

    TreeNode t3 = CODEC.deserialize("1,2");
    System.out.println(CODEC.serialize(t3));
  }
}
