package name.mdemidov.interview.leetcode.task0128;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * <p>128. Longest Consecutive Sequence
 *
 * <p>Given an unsorted array of integers, find the length of the longest consecutive elements
 * sequence.
 *
 * <p>Your algorithm should run in O(n) complexity.
 *
 * <p>Example:
 *
 * <p>Input: [100, 4, 200, 1, 3, 2]
 *
 * <p>Output: 4
 *
 * <p>Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length
 * is 4.
 */
public class Solution {
  private static final Solution S = new Solution();

  public int longestConsecutive(int[] nums) {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      if (map.containsKey(n)) {
        continue;
      }
      int left = map.getOrDefault(n - 1, 0);
      int right = map.getOrDefault(n + 1, 0);
      int sum = left + right + 1;
      res = Math.max(res, sum);
      map.put(n, sum);
      map.put(n - left, sum);
      map.put(n + right, sum);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(S.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2})); // 4
  }
}
