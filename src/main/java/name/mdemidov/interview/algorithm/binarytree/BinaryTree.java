package name.mdemidov.interview.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;
import name.mdemidov.interview.leetcode.object.TreeNode;

public class BinaryTree {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);

    System.out.println(preorderTraversal(root)); // [1, 2, 4, 5, 3]
    System.out.println(inorderTraversal(root)); // [4, 2, 5, 1, 3]
    System.out.println(postorderTraversal(root)); // [4, 5, 2, 3, 1]
  }

  /* Preorder traversal is used to create a copy of the tree. */
  private static List<Integer> preorderTraversal(TreeNode tree) {
    List<Integer> list = new ArrayList<>();
    if (tree == null) {
      return list;
    }
    list.add(tree.val);
    list.addAll(preorderTraversal(tree.left));
    list.addAll(preorderTraversal(tree.right));
    return list;
  }

  /* In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. */
  private static List<Integer> inorderTraversal(TreeNode tree) {
    List<Integer> list = new ArrayList<>();
    if (tree == null) {
      return list;
    }
    list.addAll(inorderTraversal(tree.left));
    list.add(tree.val);
    list.addAll(inorderTraversal(tree.right));
    return list;
  }

  /* Postorder traversal is used to delete the tree. */
  private static List<Integer> postorderTraversal(TreeNode tree) {
    List<Integer> list = new ArrayList<>();
    if (tree == null) {
      return list;
    }
    list.addAll(postorderTraversal(tree.left));
    list.addAll(postorderTraversal(tree.right));
    list.add(tree.val);
    return list;
  }
}
