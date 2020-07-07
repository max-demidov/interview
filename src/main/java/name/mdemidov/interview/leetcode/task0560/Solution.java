package name.mdemidov.interview.leetcode.task0560;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * <p>
 * 560. Subarray Sum Equals K
 * <p>
 * Given an array of integers and an integer k, you need to find the total number of continuous
 * subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * <p>
 * Input:nums = [1,1,1], k = 2
 * <p>
 * Output: 2
 * <p>
 * Constraints:
 * <p>
 * The length of the array is in range [1, 20,000].
 * <p>
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7,
 * 1e7].
 */
public class Solution {

  private static final Solution S = new Solution();

  public int subarraySum(int[] nums, int k) {
    int res = 0;
    if (nums[0] == k) {
      res++;
    }
    int[] sums = new int[nums.length];
    sums[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i];
      if (sums[i] == k) {
        res++;
      }
      for (int j = i - 1; j >= 0; j--) {
        if (sums[i] - sums[j] == k) {
          res++;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(S.subarraySum(new int[]{1, 1, 1}, 2)); // 2
    System.out.println(S.subarraySum(new int[]{0, 1, 1}, 2)); // 2
    System.out.println(S.subarraySum(new int[]{1, -1, 1, -1}, 0)); // 4
    System.out.println(S.subarraySum(new int[]{1}, 1)); // 1
    System.out.println(S.subarraySum(new int[]{
        1, 2, 3, 4, 5, 6, 7, 1, 23, 21, 3, 1, 2, 1, 1, 1, 1, 1, 12, 2, 3, 2, 3, 2, 2}, 1)); // 8
  }
}
