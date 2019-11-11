package name.mdemidov.interview.util;

import name.mdemidov.interview.leetcode.object.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeUtils {

    public static void main(String[] args) {
        /*
                     ___ 0 ___
                   /          \
                1               2
              /   \           /   \
           11      12      21      22
          / \     / \     / \     / \
        111 112 121 122 211 212 221 222
         */
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(22);
        root.left.left.left = new TreeNode(111);
        root.left.left.right = new TreeNode(112);
        root.left.right.left = new TreeNode(121);
        root.left.right.right = new TreeNode(122);
        root.right.left.left = new TreeNode(211);
        root.right.left.right = new TreeNode(212);
        root.right.right.left = new TreeNode(221);
        root.right.right.right = new TreeNode(222);

        System.out.println("Horizontal traversal:");
        horizontalTraversal(root).forEach(System.out::println);

        System.out.println("Vertical traversal:");
        verticalTraversal(root).values().forEach(System.out::println);
    }

    public static List<List<Integer>> horizontalTraversal(TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();
        if (root == null) {
            return tree;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int count;
        while ((count = queue.size()) > 0) {
            tree.add(queue.stream().mapToInt(n -> n.val).boxed().collect(Collectors.toList()));
            while (count > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
        }
        return tree;
    }

    public static Map<Integer, List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> tree = new TreeMap<>();
        verticalTraversal(root, 0, tree);
        return tree;
    }

    private static void verticalTraversal(TreeNode node, int dist,
                                          Map<Integer, List<Integer>> tree) {
        if (node == null) {
            return;
        }

        tree.putIfAbsent(dist, new ArrayList<>());
        tree.get(dist).add(node.val);

        verticalTraversal(node.left, dist - 1, tree);
        verticalTraversal(node.right, dist + 1, tree);
    }

}
