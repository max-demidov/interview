package name.mdemidov.interview.leetcode.task226;

import name.mdemidov.interview.leetcode.object.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode input = new TreeNode(4);
        input.left = new TreeNode(2);
        input.left.left = new TreeNode(1);
        input.left.right = new TreeNode(3);
        input.right = new TreeNode(7);
        input.right.left = new TreeNode(6);
        input.right.right = new TreeNode(9);

        TreeNode output = new Solution().invertTree(input);
        System.out.println(output);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode tmp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = tmp;
        }
        return root;
    }
}
