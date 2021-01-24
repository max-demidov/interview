package name.mdemidov.interview.leetcode.task0001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * <p>1. Two Sum
 *
 * <p>Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 *
 * <p>You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 *
 * <p>You can return the answer in any order.
 */
public class Solution {
  private static final Solution S = new Solution();

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int n = target - nums[i];
      if (map.containsKey(n)) {
        return new int[] {map.get(n), i};
      }
      map.put(nums[i], i);
    }
    return new int[] {0, 0};
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(S.twoSum(new int[] {2, 7, 11, 15}, 9))); // [0,1]
    System.out.println(Arrays.toString(S.twoSum(new int[] {3, 2, 4}, 6))); // [1,2]
    System.out.println(Arrays.toString(S.twoSum(new int[] {3, 3}, 6))); // [0,1]
  }
}
