package name.mdemidov.interview.leetcode.task0334;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * 334. Increasing Triplet Subsequence
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists
 * or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 *
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 *
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class Solution {

    private static final Solution S = new Solution();

    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) {
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(S.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(S.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
        System.out.println(S.increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4})); // true
    }
}
