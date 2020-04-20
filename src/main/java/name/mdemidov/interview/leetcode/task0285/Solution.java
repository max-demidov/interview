package name.mdemidov.interview.leetcode.task0285;

import name.mdemidov.interview.leetcode.object.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 *
 * 285. Inorder Successor in BST
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 * Example 1:
 *
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of
 * TreeNode type.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *
 * Note:
 *
 * If the given node has no in-order successor in the tree, return null.
 * It's guaranteed that the values of the tree are unique.
 */
public class Solution {

    private static final Solution S = new Solution();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = parse(root, p.val);
        return list.stream().min(Comparator.comparingInt(n -> n.val)).orElse(null);
    }

    private static List<TreeNode> parse(TreeNode node, int min) {
        List<TreeNode> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        if (node.val > min) {
            list.add(node);
            list.addAll(parse(node.left, min));
        }
        list.addAll(parse(node.right, min));
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode p1 = new TreeNode(1);
        t1.left = p1;
        t1.right = new TreeNode(3);
        System.out.println(S.inorderSuccessor(t1, p1)); // 2

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(3);
        TreeNode p2 = new TreeNode(6);
        t2.right = p2;
        t2.left.left = new TreeNode(2);
        t2.left.right = new TreeNode(4);
        t2.left.left.left = new TreeNode(1);
        System.out.println(S.inorderSuccessor(t2, p2)); // null
    }
}
