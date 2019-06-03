package name.mdemidov.interview.leetcode.task101;


import name.mdemidov.interview.leetcode.object.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode input1 = new TreeNode(1);
        input1.left = new TreeNode(2);
        input1.left.left = new TreeNode(3);
        input1.left.right = new TreeNode(4);
        input1.right = new TreeNode(2);
        input1.right.left = new TreeNode(4);
        input1.right.right = new TreeNode(3);

        TreeNode input2 = new TreeNode(1);
        input2.left = new TreeNode(2);
        input2.left.right = new TreeNode(3);
        input2.right = new TreeNode(2);
        input2.right.right = new TreeNode(3);

        boolean output1 = new Solution().isSymmetric(input1);
        boolean output2 = new Solution().isSymmetric(input2);
        System.out.println(output1);
        System.out.println(output2);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null) {
            return (treeNode1 == null && treeNode2 == null);
        }
        return treeNode1.val == treeNode2.val
               && isSymmetric(treeNode1.left, treeNode2.right)
               && isSymmetric(treeNode1.right, treeNode2.left);
    }
}
