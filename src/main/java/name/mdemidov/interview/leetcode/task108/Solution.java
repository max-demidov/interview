package name.mdemidov.interview.leetcode.task108;

import name.mdemidov.interview.leetcode.object.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *         0
 *       /  \
 *     -3   9
 *    /    /
 * -10    5
 */
public class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{-10, -3, 0, 5, 9};
        System.out.println(new Solution().sortedArrayToBST(input));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }
        int rootIndex = startIndex + (endIndex - startIndex + 1) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(nums, startIndex, rootIndex - 1);
        root.right = sortedArrayToBST(nums, rootIndex + 1, endIndex);
        return root;
    }

}
