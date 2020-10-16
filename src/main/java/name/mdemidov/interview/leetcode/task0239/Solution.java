package name.mdemidov.interview.leetcode.task0239;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * <p>239. Sliding Window Maximum
 *
 * <p>You are given an array of integers nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * <p>Return the max sliding window.
 *
 * <p>Example 1:
 *
 * <p>Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 *
 * <p>Output: [3,3,5,5,6,7]
 *
 * <p>Example 2:
 *
 * <p>Input: nums = [1], k = 1
 *
 * <p>Output: [1]
 *
 * <p>Example 3:
 *
 * <p>Input: nums = [1,-1], k = 1
 *
 * <p>Output: [1,-1]
 *
 * <p>Example 4:
 *
 * <p>Input: nums = [9,11], k = 2
 *
 * <p>Output: [11]
 *
 * <p>Example 5:
 *
 * <p>Input: nums = [4,-2], k = 2
 *
 * <p>Output: [4]
 *
 * <p>Constraints:
 *
 * <p>1 <= nums.length <= 10^5
 *
 * <p>-10^4 <= nums[i] <= 10^4
 *
 * <p>1 <= k <= nums.length
 */
public class Solution {
  private static final Solution S = new Solution();

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    if (n * k < 1) {
      return new int[0];
    }
    if (k == 1) {
      return nums;
    }

    int[] left = new int[n];
    int[] right = new int[n];
    left[0] = nums[0];
    right[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      left[i] = (i % k > 0) ? Math.max(left[i - 1], nums[i]) : nums[i];
      int j = n - i - 1;
      right[j] = ((j + 1) % k > 0) ? Math.max(right[j + 1], nums[j]) : nums[j];
    }

    int[] res = new int[n - k + 1];
    for (int i = 0; i < res.length; i++) {
      res[i] = Math.max(left[i + k - 1], right[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    print(S.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)); // [3,3,5,5,6,7]
    print(S.maxSlidingWindow(new int[] {1}, 1)); // [1]
    print(S.maxSlidingWindow(new int[] {1, -1}, 1)); // [1,-1]
    print(S.maxSlidingWindow(new int[] {9, 11}, 2)); // [11]
    print(S.maxSlidingWindow(new int[] {4, -2}, 2)); // [4]
  }

  private static void print(int[] nums) {
    System.out.println(Arrays.toString(nums));
  }
}
