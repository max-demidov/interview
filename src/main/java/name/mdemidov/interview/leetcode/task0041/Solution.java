package name.mdemidov.interview.leetcode.task0041;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * <p>
 * 41. First Missing Positive
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0] Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: [3,4,-1,1] Output: 2
 * <p>
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12] Output: 1
 * <p>
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class Solution {

  private static final Solution S = new Solution();

  public int firstMissingPositive(int[] nums) {
    Set<Integer> positives = new HashSet<>();
    for (int num : nums) {
      if (num > 0) {
        positives.add(num);
      }
    }
    int i = 0;
    while (positives.contains(++i));
    return i;
  }

  public static void main(String[] args) {
    System.out.println(S.firstMissingPositive(new int[]{1, 2, 0})); // 3
    System.out.println(S.firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
    System.out.println(S.firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // 1
    System.out.println(S.firstMissingPositive(new int[]{-1, -2})); // 1
    System.out.println(S.firstMissingPositive(new int[]{1, 1})); // 2
    System.out.println(S.firstMissingPositive(new int[]{})); // 1
    System.out.println(S.firstMissingPositive(new int[]{1})); // 2
    System.out.println(S.firstMissingPositive(new int[]{2})); // 1
  }
}
