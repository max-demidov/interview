package name.mdemidov.interview.leetcode.task0162;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is
 * fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 *
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 */
public class Solution {

    private static final Solution S = new Solution();

    public int findPeakElement(int[] nums) {
        if (nums.length < 2 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(S.findPeakElement(new int[]{1, 2, 3, 1})); // 2
        System.out.println(S.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4})); // 1 or 5
        System.out.println(S.findPeakElement(new int[]{1})); // 0
        System.out.println(S.findPeakElement(new int[]{1, 2})); // 1
        System.out.println(S.findPeakElement(new int[]{2, 1})); // 0
    }
}
