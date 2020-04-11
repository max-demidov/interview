package name.mdemidov.interview.leetcode.task0152;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            l = (l == 0 ? 1 : l) * nums[i];
            r = (r == 0 ? 1 : r) * nums[nums.length - 1 - i];
            max = Math.max(max, Math.max(l, r));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(S.maxProduct(new int[]{2, 3, -2, 4})); // 6
        System.out.println(S.maxProduct(new int[]{-2, 0, -1})); // 0
        System.out.println(S.maxProduct(new int[]{-3, 0, 1, -2})); // 1
    }
}
