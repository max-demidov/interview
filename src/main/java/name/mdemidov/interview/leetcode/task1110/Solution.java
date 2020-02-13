package name.mdemidov.interview.leetcode.task1110;

import name.mdemidov.interview.leetcode.object.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 *
 * 1110. Delete Nodes And Return Forest
 *
 * Given the root of a binary tree, each node in the tree has a distinct value.
 *
 * After deleting all nodes with a value in to_delete, we are left with a forest
 * (a disjoint union of trees).
 *
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 *
 * Example 1:
 *
 *     1
 *    / \
 *   2   3
 *  /\   /\
 * 4 5  6 7
 *
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 *
 * Constraints:
 *
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */
public class Solution {

    private static final Solution S = new Solution();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> del = new HashSet<>(to_delete.length);
        for (int i : to_delete) {
            del.add(i);
        }
        List<TreeNode> forest = new ArrayList<>();
        delNodes(root, true, del, forest);
        return forest;
    }

    private static TreeNode delNodes(
        TreeNode node, boolean isRoot, Set<Integer> del, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        boolean isToDelete = del.contains(node.val);
        if (isRoot && !isToDelete) {
            forest.add(node);
        }
        node.left = delNodes(node.left, isToDelete, del, forest);
        node.right = delNodes(node.right, isToDelete, del, forest);
        return isToDelete ? null : node;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(7);
        System.out.println(S.delNodes(t1, new int[]{3, 5}));
    }
}
