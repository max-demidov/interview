package name.mdemidov.interview.leetcode.task0428;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
 *
 * <p>428. Serialize and Deserialize N-ary Tree
 *
 * <p>Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection
 * link to be reconstructed later in the same or another computer environment.
 *
 * <p>Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree
 * in which each node has no more than N children. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree
 * can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * <p>Constraints:
 *
 * <p>The height of the n-ary tree is less than or equal to 1000
 *
 * <p>The total number of nodes is between [0, 10^4]
 *
 * <p>Do not use class member/global/static variables to store states.
 *
 * <p>Your encode and decode algorithms should be stateless.
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(Node root) {
    if (root == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(root.val);
    if (root.children != null && !root.children.isEmpty()) {
      sb.append(root.children.stream().map(this::serialize).collect(Collectors.toList()));
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public Node deserialize(String data) {
    if (data == null || data.isEmpty()) {
      return null;
    }
    int open = data.indexOf("[");
    if (open < 0) {
      return new Node(Integer.parseInt(data));
    }
    return new Node(
        Integer.parseInt(data.substring(0, open)),
        split(data.substring(open + 1, data.length() - 1)).stream()
            .map(this::deserialize)
            .collect(Collectors.toList()));
  }

  private List<String> split(String data) {
    List<String> res = new ArrayList<>();
    int left = 0;
    int level = 0;
    for (int i = 0; i < data.length(); i++) {
      if (data.charAt(i) == '[') {
        level++;
      } else if (data.charAt(i) == ']') {
        level--;
      } else if (level < 1 && data.charAt(i) == ',') {
        res.add(data.substring(left, i));
        left = i + 2;
      }
    }
    res.add(data.substring(left));
    return res;
  }

  public static void main(String[] args) {
    Codec codec = new Codec();
    Node n1 =
        new Node(
            1, asList(new Node(3, asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
    System.out.printf("Original:%n%s%n%n", n1);
    String data = codec.serialize(n1);
    System.out.printf("Serialized:%n%s%n%n", data);
    System.out.printf("Deserialized:%n%s%n%n", codec.deserialize(data));
  }

  private static final class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }

    @Override
    public String toString() {
      return String.format("%d%s", val, children == null ? "" : children);
    }
  }
}
